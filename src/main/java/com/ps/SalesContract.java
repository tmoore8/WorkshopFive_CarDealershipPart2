package com.ps;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, Vehicle vehicleSold, String customerEmail, boolean isFinanced) {
        super(date, customerName, vehicleSold, customerEmail);
        this.salesTaxAmount = vehicleSold.getPrice() * .05;
        this.recordingFee = 100;
        //ternary operator
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295 : 495;
        this.isFinanced = isFinanced;
        this.totalPrice = vehicleSold.getPrice() + salesTaxAmount + recordingFee + processingFee;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    private double calculateMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        }
        double interestRate;
        int loanLength;

        if (getVehicleSold().getPrice() >= 10000) {
            interestRate = 0.0425;
            loanLength = 48;
        } else {
            interestRate = 0.0525;
            loanLength = 24;
        }
        double loanAmount = getVehicleSold().getPrice();
        double monthlyRate = interestRate / 12;
        double monthlyPayment = (loanAmount * monthlyRate)/(1-Math.pow(1+monthlyRate,-loanLength));
        return monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

}
