package com.techno.pocs.demos;

import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.batch.core.launch.*;
import org.springframework.batch.core.*;

public class AppStarter {
    private static final String className = AppStarter.class.getSimpleName();

    public static void main(String[] args) {
        String[] configuration  = { "spring-config.xml", "springbatch-config.xml", "datasource-config.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(configuration);
        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job dataTransferJob = (Job) context.getBean("personsDataTransferJob");
        try {
            JobExecution jobExecution = jobLauncher.run(dataTransferJob, new JobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
