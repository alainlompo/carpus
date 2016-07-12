package com.techno.pocs.demos;

import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.junit4.*;
import static org.springframework.test.context.junit4.SpringJUnit4ClassRunner.*;
import org.springframework.test.context.*;
import org.springframework.batch.test.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.*;
import org.springframework.batch.core.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techno.pocs.demos.beans.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:datasource-config.xml",
        "classpath:spring-config.xml",
        "classpath:springbatch-config.xml",
        "classpath:spring-config-test.xml"})
public class AppStarterTest {
  
    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    @Autowired
    private DataSource dataSource;

    @Test
    public void launchJobTest() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertEquals("testing complete Job", BatchStatus.COMPLETED, jobExecution.getStatus());
    }

    @Test
    public void executeStep1Test() throws Exception{
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
        assertEquals("Testing step1.", BatchStatus.COMPLETED, jobExecution.getStatus());
        JdbcTemplate querier = new JdbcTemplate(dataSource);

        // See what we have in the database
        List<PersonBean> persons = getPersons(querier);
        assertEquals(3,persons.size());
        assertTrue(containsNamePart("Alain", persons));
    }

    private boolean containsNamePart(String part, List<PersonBean> list) {
      boolean result = false;
      for (PersonBean pB: list) {
        if (pB.getName().contains(part)) {
          result = true;
          break;
        }
      }
      return result;
    }

    private List<PersonBean> getPersons(JdbcTemplate jdbcTemplate) {
      String SQL = "select * from PERSONS";
      List <PersonBean> persons = jdbcTemplate.query(SQL,
                                new PersonBeanMapper());
      return persons;
   }
}
