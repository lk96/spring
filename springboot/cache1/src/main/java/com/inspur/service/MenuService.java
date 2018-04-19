package com.inspur.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.inspur.config.ApplicationContextHolder;

/**
 * Created by cat on 2017-03-12.
 */
@Component
public class MenuService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getMenuList(){
        System.out.println("");
        System.out.println("cache:get from db");
        return Arrays.asList("article","comment","admin");
    }

    public List<String> getRecommends(){
        MenuService proxy = ApplicationContextHolder.getContext().getBean(MenuService.class);
        return proxy.getMenuList();
    }
}
