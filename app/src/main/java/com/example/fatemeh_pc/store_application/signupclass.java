package com.example.fatemeh_pc.store_application;


public class signupclass {
    String cid;
    String cname;
    String clastname;
    String cemail;
    String cphone;
    String cpassword;
    String cpostalcode;
    String caddress;
    String ctype;
    int cshopcount;

    public signupclass() {
    }

    public signupclass(String cid,String cname,String clastname,String cemail,String cphone,String cpassword,String cpostalcode,String caddress){
        this.cid = cid;
        this.cname = cname;
        this.clastname = clastname;
        this.cemail = cemail;
        this.cphone = cphone;
        this.cpassword = cpassword;
        this.cpostalcode = cpostalcode;
        this.caddress = caddress;
        this.ctype = "customer";
        this.cshopcount = 0;
    }

    public void setCid(String cid){
        this.cid = cid;
    }
    public void setCname(String cname){
        this.cname = cname;
    }
    public void setClastname(String clastname){
        this.clastname = clastname;
    }
    public void setCemail(String cemail){
        this.cemail = cemail;
    }
    public void setCphone(String cphone){
        this.cphone = cphone;
    }
    public void setCpassword(String cpassword){
        this.cpassword = cpassword;
    }
    public void setCpostalcode(String cpostalcode){
        this.cpostalcode = cpostalcode;
    }
    public void setCaddress(String caddress){
        this.caddress = caddress;
    }

    public String getCid(){
        return this.cid;
    }
    public String getCname(){
        return this.cname;
    }
    public String getClastname(){
        return this.clastname;
    }
    public String getCemail(){
        return this.cemail;
    }
    public String getCphone(){
        return this.cphone;
    }
    public String getCpassword(){
        return this.cpassword;
    }
    public String getCpostalcode(){
        return this.cpostalcode;
    }
    public String getCaddress(){
        return this.caddress;
    }


}
