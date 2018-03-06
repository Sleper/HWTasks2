package domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by p998fga on 2018.03.06.
 */
public class Loan {
    private Date creationDate;
    private String name;
    private int termInYears;
    public BigDecimal calculateInterest;
    public BigDecimal interestRate;
    public BigDecimal price;
    public BigDecimal TotalLoanCost;
    public boolean isValid;
    private LoanRiskType riskType;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public BigDecimal getCalculateInterest() {
        return calculateInterest;
    }

    public void setCalculateInterest(BigDecimal calculateInterest) {
        this.calculateInterest = calculateInterest;
    }
    
    public BigDecimal calculateInterest() {
        return price.multiply(interestRate.divide(new BigDecimal(100)));
    }

    public BigDecimal getinterestRate() {
        return interestRate;
    }

    public void setinterestRate(BigDecimal interestRate) {
        interestRate = interestRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalLoanCost() {
        return TotalLoanCost;
    }

    public void setTotalLoanCost(BigDecimal totalLoanCost) {
        TotalLoanCost = totalLoanCost;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public LoanRiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(LoanRiskType riskType) {
        this.riskType = riskType;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
