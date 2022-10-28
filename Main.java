
import Items.Item;
import Items.ItemRequest;
import Payments.Payment;
import Payments.PaymentByCard;
import Payments.PaymentByCash;
import SettingNamesPrices.NamePriceOfItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    final static Inventory inventory = new Inventory();
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);

        System.out.println("Welcome what would you like to have");
        System.out.println("Here is List of all available Items:");
        HashMap<String, ArrayList<Item>> inventoryList = inventory.getItems();

        inventoryList.keySet().forEach((val)->{
            System.out.println(val +": "+inventoryList.get(val).size());
        });

        System.out.println("You can add 5 Items as Maximum in your Cart");
        ArrayList<ItemRequest> itemRequest = RequestItems(obj, inventoryList);
        VendingMachine requestedItems = new VendingMachine(itemRequest);
        ArrayList<Item> itemsToProvide = inventory.ItemsProvided(requestedItems);

        System.out.println("Your Ordered Items which is to be Served");
        itemsToProvide.forEach((prod)->{
            System.out.println("{"+prod.getName()+"}");
        });
        double costToPay = findTotalPrice(itemRequest);
        double totalPrice = PaymentMode(costToPay, obj);

        System.out.println("You have to Pay total Price : "+totalPrice);

        double payment = 0;
        do{
            payment = obj.nextDouble();
            if(payment!=totalPrice){
                System.out.println("Amount you are payment is not correct");
            }
        }while(payment!=totalPrice);

        System.out.println("Your Paid the Amount Successfully");
        System.out.println("Thank You!");
    }
    public static ArrayList<ItemRequest> RequestItems(Scanner input, HashMap<String,ArrayList<Item>> inventoryList){

        int remainingItems = 5, quantity = 0,option =0;

        String[] itemsList = {NamePriceOfItem.Coke_name,NamePriceOfItem.Chips_name,NamePriceOfItem.MilkBrand_name, NamePriceOfItem.Juice_name, NamePriceOfItem.Chocolate_name};

        ArrayList<ItemRequest> arr = new ArrayList<>();
        int[] countFuncOfItems = fillingItems(inventoryList,itemsList);
        do{
            System.out.println("Enter 1.Coke 2.Chips 3. Milk 4.Juice 5.Chocolate -1.Exit");
            System.out.println("Your Selected Option having remaining Items left : "+remainingItems);
            option = input.nextInt();
            boolean flag = true;
            if(option>5){
                System.out.println("Select the valid Option which is mentioned Above:");
                flag = false;
            }
            else{
                if(inventoryList.get(itemsList[option-1]).size()!=0){
                    System.out.println("Enter how much quantity you needed for "+itemsList[option-1]);
                    System.out.println("Current Availability of this Item is "+countFuncOfItems[option-1]);
                    boolean isValid = true;
                    do{
                        quantity = input.nextInt();
                        if(quantity>countFuncOfItems[option-1] || quantity>remainingItems){
                            System.out.println("Enter valid quantity of Items");
                        }
                        else{
                            isValid = false;
                        }
                    }while(isValid);
                }
                else{
                    System.out.println("This Item is no more Available, choose something else");
                    flag = false;
                }
            }
            if(flag==true){
                ItemRequest itemRequest = new ItemRequest(itemsList[option-1],quantity);
                remainingItems-=quantity;
                countFuncOfItems[option-1]-=quantity;
                arr.add(itemRequest);
            }
        }while((option>5|| option<-1||option==0|| (option<5 && option>0)) && remainingItems>0);
        return arr;
    }

    private static int[] fillingItems(HashMap<String, ArrayList<Item>> inventoryList, String[] ItemsList){
        int[] arr = new int[5];

        for(int i=0;i<5;i++){
            arr[i] = inventoryList.get(ItemsList[i]).size();
        }
        return arr;
    }
    public static double findTotalPrice(ArrayList<ItemRequest> itemRequests){
        int amountToPay = 0;
        NamePriceOfItem price = new NamePriceOfItem();

        for(int i=0;i<itemRequests.size();i++){
            amountToPay += price.PriceToPay(itemRequests.get(i).getItemName(),itemRequests.get(i).getQuantity());
        }
        return amountToPay;
    }
    public static double PaymentMode(double amountToPay, Scanner input){

        PaymentByCash cash = new PaymentByCash();
        PaymentByCard card = new PaymentByCard();
        System.out.println("Select Payment Options to Pay the Amount, 1.Cash 2.Card");
        int option = 0;
        do{
            option = input.nextInt();
            if(option==1){
                amountToPay = cash.moneyToBePaid();
            }
            else if(option==2){
                amountToPay = card.moneyToBePaid();
            }
            else{
                System.out.println("Your Input is not Valid");
            }
        }while(option<=0||option>2);
        return amountToPay;
    }
}



