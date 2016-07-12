package com.techno.pocs.demos.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PersonBeanMapper implements RowMapper<PersonBean> {
   public PersonBean mapRow(ResultSet rs, int rowNum) throws SQLException {
      PersonBean person = new PersonBean();
      person.setId(rs.getInt("id"));
      person.setName(rs.getString("name"));
      person.setAddress(rs.getString("address"));
      return person;
   }
}
