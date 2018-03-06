package app;

/**
 * Created by p998fga on 2018.03.06.
 */

import domain.Loan;
import domain.LoanRiskType;
import service.LoanService;

import java.math.BigDecimal;


public class ClientApp {
    public static void main(String[] args) {

        Loan[] loans = getInitializer().initializeLoans();
        LoanService service = new LoanService(loans);
        BigDecimal averageLoanCost=service.calculateAverageLoanCost();
        System.out.print("AverageLoanCost ");
        System.out.println(averageLoanCost);
        BigDecimal highRiskCounter = service.getHighRiskLoans();
        System.out.print("HighRiskLoans ");
        System.out.println(highRiskCounter);
        System.out.print("High Risk Sum ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));
        service.setAverageCostofHighRiskLoans(service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));

        System.out.print("Normal Risk Sum ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.NORMAL_RISK));

        System.out.print("Low Risk Sum ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.LOW_RISK));

        System.out.print("getAverageCostOfHighRiskLoans ");
        System.out.println(service.getAverageCostofHighRiskLoans());

        System.out.print("maximumPriceOfNonExpiredLoans ");
        System.out.println(service.findMaximumPriceOfNonExpiredLoans());
    }


    public static DomainInitializer getInitializer() {
        return new Task1DomainInitializer();
    }
}
