package Payments;

public class PaymentByCash extends Payment{

    public double moneyToBePaid() {
        double cost = getAmountToPay();
        super.setAmountToPay(cost);

        return cost;
    }
}