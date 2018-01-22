package com.example.fatemeh_pc.store_application;
import java.util.Date;

//    itransactionid INTEGER PRIMARY KEY AUTOINCREMENT, itotalprice INTEGER," +
//            " itransportprice INTEGER, ioffprice INTEGER, idate DATETIME


public class addinvoice {
    int iid;
    int itransactionid;
    int itotalprice;
    int itransportprice;
    int ioffprice;
    String idate;
    Date date;

    public addinvoice(){}

    public addinvoice(int itotalprice, int itransportprice, int ioffprice) {
        this.itotalprice = itotalprice;
        this.itransportprice = itransportprice;
        this.ioffprice = ioffprice;
        this.date = new Date();
        this.idate = date.toString();
    }

    public void setIid              (int iid)               {this.iid = iid;}
    public void setItransactionid   (int itransactionid)    {this.itransactionid = itransactionid;}
    public void setItotalprice      (int itotalprice)       {this.itotalprice = itotalprice;}
    public void setItransportprice  (int itransportprice)   {this.itransportprice = itransportprice;}
    public void setIoffprice        (int ioffprice)         {this.ioffprice = ioffprice;}
    public void setIdate            (String idate)          {this.idate = idate;}


    public int      getIid()            {return this.iid;}
    public int      getItransactionid() {return this.itransactionid;}
    public int      getItotalprice()    {return this.itotalprice;}
    public int      getItransportprice(){return this.itransportprice;}
    public int      getIoffprice()      {return this.ioffprice;}
    public String   getIdate()          {return this.idate;}

}
