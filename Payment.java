package Payments;

public abstract class Payment {
    private double amountToPay;
    private boolean isAmountPaid;

    abstract public double moneyToBePaid();

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public boolean isAmountPaid() {
        return isAmountPaid;
    }

    public void setAmountPaid(boolean amountPaid) {
        isAmountPaid = amountPaid;
    }
}