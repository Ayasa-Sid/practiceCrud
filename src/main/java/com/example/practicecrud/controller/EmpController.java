package com.example.practicecrud.controller;


import com.example.practicecrud.entity.EmpEntity;
import com.example.practicecrud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpService empService;


    @PostMapping("/createEmp")
    public EmpEntity addEmp(@RequestBody EmpEntity empEntity) {
        return this.empService.saveEmp(empEntity);
    }
    @GetMapping("/readEmp")
    public List<EmpEntity>getAllEmp(){
        return this.empService.findAllEmpEntity();
    }
    @GetMapping("/readEmp/{id}")
    public EmpEntity getEmpById(@PathVariable int id){
        return this.empService.getEmpById(id);
    }
    @PutMapping("/updateEmp")
    public EmpEntity updateEmp(@RequestBody EmpEntity empEntity){
        return this.empService.updateEmp(empEntity);
    }

    @DeleteMapping("/deleteEmp/{id}")
        public ResponseEntity<String> deleteEmpById(@PathVariable int id){
        try {
            this.empService.deleteEmpById(id);
            return new ResponseEntity<>("delete done", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("delete not done",HttpStatus.BAD_REQUEST);
        }
    }
}