import com.ps.Contract;
import com.ps.LeaseContract;
import com.ps.SalesContract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contracts.txt", true))) { // Append mode
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                writer.write(String.format("SALE|%s|%s|%s|%s|%.2f|%.2f\n",
                        salesContract.getDate(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicleInfo(),
                        salesContract.getTotalPrice(),
                        salesContract.getMonthlyPayment()
                ));
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write(String.format("LEASE|%s|%s|%s|%s|%.2f|%.2f\n",
                        leaseContract.getDate(),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerEmail(),
                        leaseContract.getVehicleInfo(),
                        leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment()
                ));
            }
        } catch (IOException e) {
            System.err.println("Error writing to file");
        }
    }
}








