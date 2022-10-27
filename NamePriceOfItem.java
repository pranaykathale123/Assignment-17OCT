package SettingNamesPrices;

public class NamePriceOfItem {

    public static final String Coke_name = "coca-cola";
    public static final double Coke_price = 20;
    public static final String Chips_name = "Lays";
    public static final double Chips_price = 25;
    public static final String MilkBrand_name = "Amul_Milk";
    public static final double MilkBrand_price = 32;
    public static final String Chocolate_name = "Temptation";
    public static final double Chocolate_price = 80;
    public static final String Juice_name = "Orange";
    public static final double Juice_price = 30;

    public double PriceToPay(String itemName,int quantity){
        double price = 0;

        switch (itemName){
            case Coke_name:{
                price = quantity * Coke_price;
            }
            break;
            case Chips_name : {
                price = quantity*Chips_price;
            }
            break;
            case MilkBrand_name:{
                price = quantity*MilkBrand_price;
            };
            break;
            case Juice_name:{
                price = quantity*Juice_price;
            }
            break;
            case Chocolate_name:{
                price = quantity*Chocolate_price;
            }
            break;
        }
        return price;
    }
}