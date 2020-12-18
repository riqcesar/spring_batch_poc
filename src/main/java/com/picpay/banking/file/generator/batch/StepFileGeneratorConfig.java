package com.picpay.banking.file.generator.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepFileGeneratorConfig {

    @Bean
    public Step stepFileGenerator(final StepBuilderFactory stepBuilderFactory, final BankslipRepoReader bankslipRepoReader, final BankslipFlatWriter bankslipFlatWriter, final BankslipProcessor bankslipProcessor) {
        return stepBuilderFactory.get("stepFileGenerator")
            .<Bankslip, Bankslip>chunk(500)//1 = 9s -> 800ms
            .reader(bankslipRepoReader.reader())
            .processor(bankslipProcessor.processor())
            .writer(bankslipFlatWriter.writer())
            .build();
    }

}
