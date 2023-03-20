package netology.hwjdbctask1.controller;

import netology.hwjdbctask1.model.Customers;
import netology.hwjdbctask1.repository.ReadDB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class readDBController {
    ReadDB readDB;

    @GetMapping("/products/fetch-product")
    public List<String> readDBProduct(@RequestParam String name) {
        System.out.println(name);
        return ReadDB.getProductName(name);
    }
}
