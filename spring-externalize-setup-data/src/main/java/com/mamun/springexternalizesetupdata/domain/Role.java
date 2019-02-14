package com.mamun.springexternalizesetupdata.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

//@Entity
//@JsonPropertyOrder({ "id", "role", "note"})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    private   String id;

    private  String role;

    private  String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



}
