package com.mamun.springrest.domain.entity;

public class RequestObject {
    Integer nUserId;
    Integer nDeptInst;

    public Integer getnUserId() {
        return nUserId;
    }

    public void setnUserId(Integer nUserId) {
        this.nUserId = nUserId;
    }

    public Integer getnDeptInst() {
        return nDeptInst;
    }

    public void setnDeptInst(Integer nDeptInst) {
        this.nDeptInst = nDeptInst;
    }

    public RequestObject(Integer nUserId, Integer nDeptInst) {
        this.nUserId = nUserId;
        this.nDeptInst = nDeptInst;
    }
}
