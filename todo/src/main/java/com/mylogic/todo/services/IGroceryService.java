package com.mylogic.todo.services;

import com.mylogic.todo.models.GroceryItem;
import com.mylogic.todo.responses.GroceryItemResponse;

public interface IGroceryService {
    public GroceryItemResponse getAllItems();
    public GroceryItemResponse getItembyId(int id);
    public GroceryItemResponse getItembyName(String name);
    public GroceryItemResponse addItem(GroceryItem groceryItem);
    public long                 getCount();
    public GroceryItemResponse  deleteItem(int id);
    public GroceryItemResponse updateItem(GroceryItem groceryItem);
}
