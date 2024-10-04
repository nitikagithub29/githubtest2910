package com.example.examplecrudoperation.service;

import com.example.examplecrudoperation.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    public List<Item> fetchItemsFromUrl(String url) {
        RestTemplate restTemplate3 = new RestTemplate();
        Item[] items = restTemplate3.getForObject(url, Item[].class);
        return Arrays.asList(items);
    }
}
