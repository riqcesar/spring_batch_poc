package com.picpay.banking.file.generator.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobFileGeneratorConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job fileGenerator(Step step){
        return jobBuilderFactory
            .get("fileGenerator")
            .start(step)
            .build();
    }

}
