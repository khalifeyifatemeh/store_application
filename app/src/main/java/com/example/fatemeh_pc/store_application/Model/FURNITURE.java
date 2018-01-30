package com.example.fatemeh_pc.store_application.Model;

/**
 * Created by FATEMEH-PC on 1/30/2018.
 */

public class FURNITURE {
    String title;
    String price;
    int imgid;

    public FURNITURE(String title, String price, int imgid) {
        this.title = title;
        this.price = price;
        this.imgid=imgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
