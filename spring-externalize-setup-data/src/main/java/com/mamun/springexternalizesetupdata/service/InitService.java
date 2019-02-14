package com.mamun.springexternalizesetupdata.service;

import com.mamun.springexternalizesetupdata.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitService {

    @Autowired
    LoadSetupData loadSetupData;

    @PostConstruct
    private void setupData() {

        List<Role> roles =  loadSetupData.loadObjectList(Role.class, "role.csv");

    }
}
