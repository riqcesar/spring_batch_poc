package com.picpay.banking.file.generator.batch;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class BankslipFlatWriter {

    @Value("file:files/cob605.rok")
    private Resource resourceFile;

    public FlatFileItemWriter<Bankslip> writer(){
        return new FlatFileItemWriterBuilder<Bankslip>()
            .name("writer")
            .resource(resourceFile)
            .formatted()
            .format("%-32s%-20s%-15s%-8s%-1s")
            .names("barcode", "expiredDate", "amount", "institutionCode", "status")
            .build();
    }


}
