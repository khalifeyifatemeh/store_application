package com.example.fatemeh_pc.store_application;


public class adduser {
    int uid;
    String uname;
    String ulastname;
    String uemail;
    String uphone;
    String upassword;
    String upostalcode;
    String uaddress;
    String utype;
    int ushopcount;

    public adduser() {
    }



    public adduser(String uname,String ulastname,String uemail,String uphone,String upassword,String upostalcode,String uaddress){
        this.uname = uname;
        this.ulastname = ulastname;
        this.uemail = uemail;
        this.uphone = uphone;
        this.upassword = upassword;
        this.upostalcode = upostalcode;
        this.uaddress = uaddress;
        this.utype = "customer";
        this.ushopcount = 0;
    }

    public void setUid          (int uid)           { this.uid = uid; }
    public void setUname        (String uname)      { this.uname = uname; }
    public void setUlastname    (String ulastname)  { this.ulastname = ulastname; }
    public void setUemail       (String uemail)     { this.uemail = uemail; }
    public void setUphone       (String uphone)     { this.uphone = uphone; }
    public void setUpassword    (String upassword)  { this.upassword = upassword; }
    public void setUpostalcode  (String upostalcode){ this.upostalcode = upostalcode;}
    public void setUaddress     (String uaddress)   { this.uaddress = uaddress; }
    public void setUtype        (String utype)      { this.utype=utype; }
    public void setUshopcount   (int ushopcount)    { this.ushopcount = ushopcount; }

    public int getUid()             { return this.uid; }
    public String getUname()        { return this.uname; }
    public String getUlastname()    { return this.ulastname; }
    public String getUemail()       { return this.uemail; }
    public String getUphone()       { return this.uphone; }
    public String getUpassword()    { return this.upassword; }
    public String getUpostalcode()  { return this.upostalcode; }
    public String getUaddress()     { return this.uaddress; }
    public String getUtype()        { return this.utype; }
    public int    getUshopcount()   { return this.ushopcount; }

}
