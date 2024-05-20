package com.ps;

public class LeaseContract extends Contract{
    private double endingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, Vehicle vehicleSold, String customerEmail) {
        super(date, customerName, vehicleSold, customerEmail);
        this.endingValue = vehicleSold.getPrice() * .5;
        this.leaseFee = vehicleSold.getPrice() * .07;
        this.totalPrice = vehicleSold.getPrice() + leaseFee;
        this.monthlyPayment = calculateMonthlyPayment();

    }
    private double calculateMonthlyPayment(){
        int leaseLength = 36;
        double interestRate = .04;
        double loanAmount = totalPrice - endingValue;
        double monthlyPayment = (loanAmount * (1+ interestRate * (leaseLength/12))) / leaseLength;
        return monthlyPayment;
    }


    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }
}
