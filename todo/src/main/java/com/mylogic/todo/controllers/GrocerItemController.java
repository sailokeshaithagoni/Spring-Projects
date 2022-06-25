package com.mylogic.todo.controllers;

import com.mylogic.todo.models.GroceryItem;
import com.mylogic.todo.responses.GroceryItemResponse;
import com.mylogic.todo.services.IGroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GrocerItemController {

    @Autowired
    private IGroceryService iGroceryService;

    @RequestMapping(value = "/api/add-item", method = RequestMethod.POST)
    public GroceryItemResponse addItem(ModelMap model, @Valid GroceryItem groceryItem, BindingResult result)
    {
        return iGroceryService.addItem(groceryItem);
    }

    @RequestMapping(value = "/api/get-all-items", method = RequestMethod.GET)
    public GroceryItemResponse getItems()
    {
        return iGroceryService.getAllItems();
    }
}
