package com.example.fatemeh_pc.store_application;

public class addfurniture {

    int fid;
    String fname;
    String ftype;
    String fprice;
    String fcolor;
    String ffabric;
    String fwood;
    String fcount;
    String fkosan;
    String fexist;
    String fimage;

    public addfurniture(){}

    public addfurniture(int fid,String fname,String ftype,String fprice,String fcolor,String ffabric,String fwood,String fcount,String fkosan,String fexist,String fimage){
        this.fid = fid;
        this.fname = fname;
        this.ftype = ftype;
        this.fprice = fprice;
        this.fcolor = fcolor;
        this.ffabric = ffabric;
        this.fwood = fwood;
        this.fcount = fcount;
        this.fkosan = fkosan;
        this.fexist = fexist;
        this.fimage = fimage;
    }

    public void setFid(int fid){
        this.fid = fid;
    }
    public void setFname(String fname){
        this.fname = fname;
    }
    public void setFtype(String ftype){
        this.ftype = ftype;
    }
    public void setFprice(String fprice){
        this.fprice = fprice;
    }
    public void setFcolor(String fcolor){
        this.fcolor = fcolor;
    }
    public void setFfabric(String ffabric){
        this.ffabric = ffabric;
    }
    public void setFwood(String fwood){
        this.fwood = fwood;
    }
    public void setFcount(String fcount){
        this.fcount = fcount;
    }
    public void setFkosan(String fkosan){
        this.fkosan = fkosan;
    }
    public void setFexist(String fexist){
        this.fexist = fexist;
    }
    public void setFimage(String fimage){
        this.fimage = fimage;
    }

    public int getFid() {
        return this.fid;
    }
    public String getFname() {
        return this.fname;
    }
    public String getFtype() {
        return this.ftype;
    }
    public String getFprice() {
        return this.fprice;
    }
    public String getFcolor() {
        return this.fcolor;
    }
    public String getFfabric() {
        return this.ffabric;
    }
    public String getFwood() {
        return this.fwood;
    }
    public String getFcount() {
        return this.fcount;
    }
    public String getFkosan() {
        return this.fkosan;
    }
    public String getFexist() {
        return this.fexist;
    }
    public String getFimage() {
        return this.fimage;
    }

}
