import Items.ItemRequest;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<ItemRequest> reqItems;

    public VendingMachine(ArrayList<ItemRequest> reqItems){
        this.reqItems = reqItems;
    }

    public ArrayList<ItemRequest> getReqItems() {
        return reqItems;
    }

    public void setReqItems(ArrayList<ItemRequest> reqItems) {
        this.reqItems = reqItems;
    }
}