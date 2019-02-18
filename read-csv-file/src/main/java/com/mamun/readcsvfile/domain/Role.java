package com.mamun.readcsvfile.domain;


public class Role {

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


    public Role(String id, String role, String note) {
        this.id = id;
        this.role = role;
        this.note = note;
    }

    public Role() {
    }
}
