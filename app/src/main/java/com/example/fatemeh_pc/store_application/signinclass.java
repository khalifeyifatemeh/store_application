package com.example.fatemeh_pc.store_application;


public class signinclass {
    String uphone;
    String upassword;

    public signinclass(){
    }

    public signinclass(String uphone, String upassword){
        this.uphone = uphone;
        this.upassword = upassword;
    }

    public void setuphone(String uphone){
        this.uphone = uphone;
    }

    public void setupassword(String upassword){
        this.upassword = upassword;
    }

    public String getuphone(){
        return this.uphone;
    }

    public  String getupassword(){
        return this.upassword;
    }
}
