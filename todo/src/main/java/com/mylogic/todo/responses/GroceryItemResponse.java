package com.mylogic.todo.responses;

import com.mylogic.todo.models.GroceryItem;

import java.util.List;

public class GroceryItemResponse extends BaseResponse{
    private List<GroceryItem> groceryItemList;
    private long              count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<GroceryItem> getGroceryItemList() {
        return groceryItemList;
    }

    public void setGroceryItemList(List<GroceryItem> groceryItemList) {
        this.groceryItemList = groceryItemList;
    }

}
