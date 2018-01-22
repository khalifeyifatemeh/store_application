package com.example.fatemeh_pc.store_application;


public class addufi {
    int uid;
    int fid;
    int iid;

    public addufi(){}

    public addufi(int uid, int fid, int iid){
        this.uid = uid;
        this.fid = fid;
        this.iid = iid;
    }
//    4745
    public void setUid(int uid){this.uid = uid;}
    public void setFid(int fid){this.fid = fid;}
    public void setIid(int iid){this.iid = iid;}

    public int getUid(){return this.uid;}
    public int getFid(){return this.fid;}
    public int getIid(){return this.iid;}

}
