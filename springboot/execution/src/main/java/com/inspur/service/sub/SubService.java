package com.inspur.service.sub;

import org.springframework.stereotype.Component;

import com.inspur.service.ProductService;


@Component
public class SubService extends ProductService{

    public void demo(){
        System.out.println("execute sub service method");
    }
}
