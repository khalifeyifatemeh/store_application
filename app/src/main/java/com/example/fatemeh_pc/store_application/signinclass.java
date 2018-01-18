package com.example.fatemeh_pc.store_application;


public class signinclass {
    String cphone;
    String cpassword;

    public signinclass(){
    }

    public signinclass(String cphone, String cpassword){
        this.cphone = cphone;
        this.cpassword = cpassword;
    }

    public void setCphone(String cphone){
        this.cphone = cphone;
    }

    public void setCpassword(String cpassword){
        this.cpassword = cpassword;
    }

    public String getCphone(){
        return this.cphone;
    }

    public  String getCpassword(){
        return this.cpassword;
    }
}
