package com.example.fatemeh_pc.store_application.Model;

/**
 * Created by FATEMEH-PC on 1/30/2018.
 */

public class FURNITURE {
    String title;
    String id;
    int imgid;

    public FURNITURE(String title, String id, int imgid) {
        this.title = title;
        this.id = id;
        this.imgid=imgid;
    }

    public FURNITURE() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
