package com.inspur.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.dao.OperationLogDao;
import com.inspur.dao.UserDao;
import com.inspur.domain.OperationLog;
import com.inspur.domain.User;


@Component
public class DemoService {

    @Autowired
    UserDao userDao;

    @Autowired
    OperationLogDao operationLogDao;

    @Transactional
    public void addUser(String name){
        OperationLog log = new OperationLog();
        log.setContent("create user:"+name);
        operationLogDao.save(log);

        User user = new User();
        user.setName(name);
        userDao.save(user);
    }
}
