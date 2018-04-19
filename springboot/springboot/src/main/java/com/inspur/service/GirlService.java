package com.inspur.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspur.domain.Girl;
import com.inspur.enums.ResultEnum;
import com.inspur.exception.GirlException;
import com.inspur.repository.GirlRepository;


@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setNum("1");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setNum("222");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
    	Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();
        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

       
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Object findOne(Integer id) {
        return girlRepository.findById(id);
    }
}
