package com.picpay.banking.file.generator.batch;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BankslipRepoReader {

    @Autowired
    private BankslipRepository bankslipRepository;

    public RepositoryItemReader<Bankslip> reader() {
        RepositoryItemReader<Bankslip> reader = new RepositoryItemReader<>();
        reader.setRepository(bankslipRepository);
        reader.setMethodName("findByStatus");
        reader.setArguments(List.of(Status.NOT_REGISTERED));
        reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return reader;
    }

    private void insertBankslips() {
        List<Bankslip> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(new Bankslip("barcode" + i, LocalDate.now(), new BigDecimal("1000.0").add(new BigDecimal(i)), 380 + i, Status.REGISTERED));
        }
        for (int i = 501; i < 1000; i++) {
            list.add(new Bankslip("barcode" + i, LocalDate.now(), new BigDecimal("1000.0").add(new BigDecimal(i)), 380 + i, Status.NOT_REGISTERED));
        }
        bankslipRepository.saveAll(list);
    }


}
