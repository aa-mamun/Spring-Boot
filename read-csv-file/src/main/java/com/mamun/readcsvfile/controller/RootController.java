package com.mamun.readcsvfile.controller;

import com.mamun.readcsvfile.domain.Role;
import com.mamun.readcsvfile.service.ReadCsvFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootController {

    @Autowired
    ReadCsvFile readCsvFile;

@RequestMapping("/read-csv-file")
   public List<Role> readCsvData(){

    List<Role> data = readCsvFile.readData("role.csv");

    return data;
   }

}
