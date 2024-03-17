package com.patika.kredinbizdenservice.model;


import com.patika.kredinbizdenservice.enums.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(BigDecimal amount, Integer installment, Double interestRate, Campaign campaign) {
        super(amount, installment, interestRate, campaign);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }


}