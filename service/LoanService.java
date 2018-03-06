package service;


import domain.Loan;
import domain.LoanRiskType;
import udil.DateUtil;

import java.math.BigDecimal;
import java.util.Date;


public class LoanService {


    public Loan[] loan;
    public BigDecimal getHighRiskLoans;
    public BigDecimal averageLoanCost;
    public BigDecimal maximumPriceOfNonExpiredLoans;
    private BigDecimal averageCostOfHighRiskLoan;

    public BigDecimal getaverageCostofHighRiskLoans() {
        return averageCostofHighRiskLoans;
    }

    public void setaverageCostofHighRiskLoans(BigDecimal averageCostofHighRiskLoans) {
        this.averageCostofHighRiskLoans = averageCostofHighRiskLoans;
    }

    private BigDecimal averageCostofHighRiskLoans;

    public LoanService(Loan[] loan) {
        this.loan = loan;
    }

    public BigDecimal calculateAverageLoanCost() {
        BigDecimal averageLoanCost = BigDecimal.ZERO;
        for (int i = 0; i < loan.length; i++) {
            averageLoanCost = averageLoanCost.add(loan[i].getPrice().multiply(loan[i].getinterestRate().divide(new BigDecimal(100)).add(new BigDecimal(1))));
        }
        return averageLoanCost.divide(BigDecimal.valueOf(loan.length));
    }

    public BigDecimal getGetHighRiskLoans() {
        return getHighRiskLoans;
    }

    public void setGetHighRiskLoans(BigDecimal getHighRiskLoans) {
        this.getHighRiskLoans = getHighRiskLoans;
    }

    public BigDecimal getHighRiskLoans() {
        BigDecimal highRiskCounter = BigDecimal.ZERO;
        for (int i = 0; i < loan.length; i++) {
            if (loan[i].getRiskType().equals(LoanRiskType.HIGH_RISK)) {
                highRiskCounter = highRiskCounter.add(new BigDecimal(1));
            }
        }
        return highRiskCounter;
    }

    public BigDecimal getaverageLoanCost() {

        return averageLoanCost;
    }

    public void setaverageLoanCost(BigDecimal getAverageLoanCost) {
        this.averageLoanCost = getAverageLoanCost;
    }

    public BigDecimal getmaximumPriceOfNonExpiredLoans() {
        return maximumPriceOfNonExpiredLoans;
    }

    public void setmaximumPriceOfNonExpiredLoans(BigDecimal maximumPriceOfNonExpiredLoans) {
        this.maximumPriceOfNonExpiredLoans = maximumPriceOfNonExpiredLoans;
    }

    public BigDecimal findMaximumPriceOfNonExpiredLoans() {
        BigDecimal maximumPrice = BigDecimal.ZERO;
        Date tempa = DateUtil.getDateFromString("2018-03-06");
        for (int i = 0; i < loan.length; i++) {
            Date tempD = DateUtil.addYears(loan[i].getCreationDate(), loan[i].getTermInYears());
            if (DateUtil.differenceInDays(tempD, tempa) > 0) {
                if (maximumPrice.compareTo(loan[i].getPrice()) < 0) {
                    maximumPrice = loan[i].getPrice();
                }
            }
        }
        return maximumPrice;
    }


    public BigDecimal calculateAverageLoanCost(LoanRiskType riskType) {
        int temp = 0;
        BigDecimal riskTypeSum = BigDecimal.ZERO;
        for (int i = 0; i < loan.length; i++) {
            if (loan[i].getRiskType().equals(riskType)) {
                riskTypeSum = riskTypeSum.add(loan[i].getPrice().multiply(loan[i].getinterestRate().divide(new BigDecimal(100)).add(new BigDecimal(1))));
                temp++;
            }
        }
        return riskTypeSum.divide(BigDecimal.valueOf(temp));
    }


    public void setAverageCostofHighRiskLoans(BigDecimal averageCostofHighRiskLoans) {
        this.averageCostofHighRiskLoans = averageCostofHighRiskLoans;
    }

    public BigDecimal getAverageCostofHighRiskLoans() {
        return averageCostofHighRiskLoans;
    }
}
