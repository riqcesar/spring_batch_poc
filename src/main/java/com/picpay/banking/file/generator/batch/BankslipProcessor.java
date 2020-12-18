package com.picpay.banking.file.generator.batch;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BankslipProcessor {

    public FunctionItemProcessor<Bankslip, Bankslip> processor(){
        return new FunctionItemProcessor<>(eachBankslip -> eachBankslip.addJuros(5));
    }

}
