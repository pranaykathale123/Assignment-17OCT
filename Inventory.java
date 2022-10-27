import Items.*;
import SettingNamesPrices.NamePriceOfItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final HashMap<String, ArrayList<Item>> inventory;

    public Inventory(){
        inventory = new HashMap<>();
        fillItemInInventory();
    }

    private void fillItemInInventory(){
        inventory.put(NamePriceOfItem.Coke_name, fillCokeItems());
        inventory.put(NamePriceOfItem.Chips_name, fillChipsItems());
        inventory.put(NamePriceOfItem.MilkBrand_name, fillMilkItems());
        inventory.put(NamePriceOfItem.Juice_name, fillJuiceItems());
        inventory.put(NamePriceOfItem.Chocolate_name, fillChocolateItems());
    }
    private ArrayList<Item> fillCokeItems(){

        ArrayList<Item> arr = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr.add(new Coke());
        }
        return arr;
    }
    private ArrayList<Item> fillChipsItems(){

        ArrayList<Item> arr = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr.add(new Chips());
        }
        return arr;
    }
    private ArrayList<Item> fillMilkItems(){

        ArrayList<Item> arr = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr.add(new Milk());
        }
        return arr;
    }
    private ArrayList<Item> fillJuiceItems(){

        ArrayList<Item> arr = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr.add(new Juice());
        }
        return arr;
    }
    private ArrayList<Item> fillChocolateItems(){

        ArrayList<Item> arr = new ArrayList<>();

        for(int i=0;i<5;i++){
            arr.add(new Chocolate());
        }
        return arr;
    }

    public boolean isItemAvailable(String itemName){
        if(inventory.get(itemName).size()>0){
            return true;
        }
        return false;
    }
    public HashMap<String, ArrayList<Item>> getItems() {
        return inventory;
    }
    public ArrayList<Item> ItemsProvided(VendingMachine req){
        ArrayList<Item> arr = new ArrayList<>();

        req.getReqItems().forEach((product)->{
            ArrayList<Item> items = inventory.get(product.getItemName());
            int currSize = inventory.get(product.getItemName()).size();
            for(int i=0;i< product.getQuantity();i++){
                arr.add(items.remove(0));
            }
        });
        return arr;
    }
}