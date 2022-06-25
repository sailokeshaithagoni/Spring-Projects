package com.mylogic.todo.services;

import com.mylogic.todo.models.GroceryItem;
import com.mylogic.todo.repos.ItemRepository;
import com.mylogic.todo.responses.GroceryItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryServiceImpl implements IGroceryService {
    @Autowired
    private ItemRepository itemRepository;
    private GroceryItemResponse groceryItemResponse;

    @Override
    public GroceryItemResponse getAllItems() {
        try {
            groceryItemResponse.setGroceryItemList(itemRepository.findAll());
            return groceryItemResponse;
        }
        catch (Exception exception)
        {
            groceryItemResponse.setErorCode(400);
            groceryItemResponse.setErrorDescription("No items aavailable");
            return groceryItemResponse;
        }
    }

    @Override
    public GroceryItemResponse getItembyId(int id) {
        try {
            //TODO:
            //groceryItemResponse.setGroceryItemList(itemRepository.findById(String.valueOf(id)));
            return groceryItemResponse;
        }
        catch (Exception exception)
        {
            groceryItemResponse.setErorCode(400);
            groceryItemResponse.setErrorDescription("No items aavailable");
            return groceryItemResponse;
        }
    }

    @Override
    public GroceryItemResponse getItembyName(String name) {
        return null;
    }

    @Override
    public GroceryItemResponse addItem(GroceryItem groceryItem) {
        try {
            itemRepository.save(groceryItem);
            groceryItemResponse.setGroceryItemList(itemRepository.findAll());
            return groceryItemResponse;
        }
        catch (Exception exception)
        {
            groceryItemResponse.setErorCode(400);
            groceryItemResponse.setErrorDescription("No items aavailable");
            return groceryItemResponse;
        }
    }

    @Override
    public long getCount() { return itemRepository.count();    }

    @Override
    public GroceryItemResponse deleteItem(int id) {
        try
        {
            itemRepository.deleteById(String.valueOf(id));
            groceryItemResponse.setCount(getCount());
            return groceryItemResponse;
        }
        catch (Exception exception)
        {
            groceryItemResponse.setErorCode(400);
            groceryItemResponse.setErrorDescription(exception.getMessage());
            return groceryItemResponse;
        }
    }

    @Override
    public GroceryItemResponse updateItem(GroceryItem groceryItem) {
        try
        {
            itemRepository.save(groceryItem);
            groceryItemResponse.setCount(getCount());
            return groceryItemResponse;
        }
        catch (Exception exception)
        {
            groceryItemResponse.setErorCode(400);
            groceryItemResponse.setErrorDescription(exception.getMessage());
            return groceryItemResponse;
        }
    }
}
