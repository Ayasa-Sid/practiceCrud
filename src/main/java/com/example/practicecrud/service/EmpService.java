package com.example.practicecrud.service;


import com.example.practicecrud.entity.EmpEntity;
import com.example.practicecrud.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;


    public EmpEntity saveEmp(EmpEntity empEntity){

        return this.empRepository.save(empEntity);
    }

    public List<EmpEntity>findAllEmpEntity(){
        return this.empRepository.findAll();
    }

    public EmpEntity getEmpById(int id){

        return this.empRepository.findById(id).orElse(null);
    }

    public EmpEntity updateEmp(EmpEntity empEntity){

        return this.empRepository.save(empEntity);
    }


    public void deleteEmpById(int id){
         this.empRepository.deleteById(id);
    }
}
