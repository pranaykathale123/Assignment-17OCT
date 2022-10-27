package Payments;

public class PaymentByCard extends Payment{

    public double moneyToBePaid(){
        double cost = getAmountToPay()*2;
        super.setAmountToPay(cost);
        return cost;
    }
}