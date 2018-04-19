package com.inspur.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * //匹配ProductService类里头的所有方法
 * @Pointcut("within(com.inspur.service.ProductService)")
 * //匹配com.inspur包及子包下所有类的方法
 * @Pointcut("within(com.inspur..*)")
 * Created by cat on 2017-02-19.
 */
@Aspect
@Component
public class PkgTypeAspectConfig {
//    @Pointcut("within(com.inspur.service.sub.*)")
//    public void matchType(){}
//
//    @Before("matchType()")
//    public void before(){
//        System.out.println("");
//        System.out.println("###before");
//    }
}
