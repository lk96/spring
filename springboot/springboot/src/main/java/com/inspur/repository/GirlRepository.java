package com.inspur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.domain.Girl;

import java.util.List;


public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
