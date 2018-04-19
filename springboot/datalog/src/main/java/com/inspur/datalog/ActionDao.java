package com.inspur.datalog;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inspur.domain.Action;

public interface ActionDao extends MongoRepository<Action,String> {
}
