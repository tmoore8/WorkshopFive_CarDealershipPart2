package com.ps;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String date, String customerName, Vehicle vehicleSold, String customerEmail) {
        this.date = date;
        this.customerName = customerName;
        this.vehicleSold = vehicleSold;
        this.customerEmail = customerEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
    public String getVehicleInfo() {
        Vehicle vehicle = getVehicleSold();
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                vehicle.getVin(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getColor(),
                vehicle.getOdometer(),
                vehicle.getPrice());
    }
}

