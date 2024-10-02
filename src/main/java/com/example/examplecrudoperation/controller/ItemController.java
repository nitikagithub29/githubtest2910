package com.example.examplecrudoperation.controller;

import com.example.examplecrudoperation.model.Item;
import com.example.examplecrudoperation.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems(@RequestParam String url) {
        return itemService.fetchItemsFromUrl(url);
    }

    @GetMapping("/itemsByUserId")
    public List<Item> getItemsByUserId(@RequestParam String url, @RequestParam Long userId) {
        List<Item> items = itemService.fetchItemsFromUrl(url);
        return items.stream()
                .filter(item -> item.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
