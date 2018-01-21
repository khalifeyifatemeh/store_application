package com.example.fatemeh_pc.store_application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "moblplus.db";

    // Table Names
    private static final String TABLE_user      = "user";
    private static final String TABLE_furniture = "furniture";
    private static final String TABLE_invoice   = "invoice";
    private static final String TABLE_cfi       = "cfi";

    // Table Create Statements
    // user table create statement
    private static final String CREATE_TABLE_user = "CREATE TABLE " +
            TABLE_user + "( uid INTEGER PRIMARY KEY AUTOINCREMENT, uname TEXT, ulastname TEXT," +
            " uemail TEXT, uphone TEXT,upassword TEXT, upostalcode TEXT, uaddress TEXT, " +
            " utype TEXT, ushopcount INTEGER)";

    // furniture table create statement
    private static final String CREATE_TABLE_furniture = "CREATE TABLE " +
            TABLE_furniture + "( fid INTEGER PRIMARY KEY AUTOINCREMENT, fname TEXT, ftype TEXT," +
            " fprice TEXT, fcolor TEXT, ffabric TEXT, fwood TEXT, fkosan TEXT, " +
            " fexist TEXT, fimage TEXT)";

    // invoice table create statement
    private static final String CREATE_TABLE_invoice = "CREATE TABLE " +
            TABLE_invoice + "( itransactionid INTEGER PRIMARY KEY AUTOINCREMENT, itotalprice INTEGER," +
            " itransportprice INTEGER, ioffprice INTEGER, idate DATETIME)";

    // invoice table create statement
    private static final String CREATE_TABLE_cfi = "CREATE TABLE " +
            TABLE_cfi + "(uid TEXT, fid TEXT, itransactionid INTEGER," +
            " PRIMARY KEY (uid, fid, itransactionid))";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_user);
        db.execSQL(CREATE_TABLE_furniture);
        db.execSQL(CREATE_TABLE_invoice);
        db.execSQL(CREATE_TABLE_cfi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_user);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_furniture);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_invoice);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_cfi);

        // create new tables
        onCreate(db);
    }


    /**
     *
     *CRUD for user
     *
    **/


    /**
     * @intro insert user to user table
     * @param user
     * @return long
     */
    public long createUser(adduser user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("uname",        user.getUname());
        values.put("ulastname",    user.getUlastname());
        values.put("uemail",       user.getUemail());
        values.put("uphone",       user.getUphone());
        values.put("upassword",    user.getUpassword());
        values.put("upostalcode",  user.getUpostalcode());
        values.put("uaddress",     user.getUaddress());
        values.put("utype",        user.getUtype());
        values.put("ushopcount",   user.getUshopcount());

        long userID = db.insert(TABLE_user, null, values);

        return userID;
    }


    /**
     * @intro select specific user used in sign in class
     * @param uphone
     * @param upassword
     * @return adduser class
     */
    public adduser getUser(String uphone, String upassword){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_user + " WHERE " +
                "uphone  = " + uphone + ", upassword  = " + upassword;

        /*
        The Android system uses a centralized system for all logs.
        The application programmer can also write custom log messages.
         */
        Log.e(LOG, selectQuery);

        /*
        The basic purpose of a cursor is to point to a
        single row of the result fetched by the query.
        We load the row pointed by the cursor object.
        By using cursor we can save lot of ram and memory.
         */
        Cursor c = db.rawQuery(selectQuery, null);

        /*
        Move the cursor to the first row.
        This method will return false if the cursor is empty.
         */
        if (c != null)
            c.moveToFirst();

        adduser user = new adduser();
        user.setUid         (c.getInt       (c.getColumnIndex("uid")));
        user.setUname       ((c.getString   (c.getColumnIndex("uname"))));
        user.setUlastname   ((c.getString   (c.getColumnIndex("ulastname"))));
        user.setUemail      ((c.getString   (c.getColumnIndex("uemail"))));
        user.setUphone      ((c.getString   (c.getColumnIndex("uphone"))));
        user.setUpassword   ((c.getString   (c.getColumnIndex("upassword"))));
        user.setUpostalcode ((c.getString   (c.getColumnIndex("upostalcode"))));
        user.setUaddress    ((c.getString   (c.getColumnIndex("uaddress"))));
        user.setUtype       ((c.getString   (c.getColumnIndex("utype"))));
        user.setUshopcount  ((c.getInt      (c.getColumnIndex("ushopcount"))));

        return user;
    }

    /**
     * @intro select all users from user table
     * @return users which is a list of the adduser class
     */
    public List<adduser> getAllUsers(){
        List<adduser> users = new ArrayList<adduser>();
        String selectQuery = "SELECT * FROM user";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to users list
        if (c.moveToFirst()) {
            do{
                adduser user = new adduser();
                user.setUid         (c.getInt       (c.getColumnIndex("uid")));
                user.setUname       ((c.getString   (c.getColumnIndex("uname"))));
                user.setUlastname   ((c.getString   (c.getColumnIndex("ulastname"))));
                user.setUemail      ((c.getString   (c.getColumnIndex("uemail"))));
                user.setUphone      ((c.getString   (c.getColumnIndex("uphone"))));
                user.setUpassword   ((c.getString   (c.getColumnIndex("upassword"))));
                user.setUpostalcode ((c.getString   (c.getColumnIndex("upostalcode"))));
                user.setUaddress    ((c.getString   (c.getColumnIndex("uaddress"))));
                user.setUtype       ((c.getString   (c.getColumnIndex("utype"))));
                user.setUshopcount  ((c.getInt      (c.getColumnIndex("ushopcount"))));

                //adding to users list
                users.add(user);
            }while(c.moveToNext());
        }
        return users;
    }

    /**
     * @intro update single user
     * @param user
     * @return Uid
     */
    public long updateUser(adduser user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("uname",        user.getUname());
        values.put("ulastname",    user.getUlastname());
        values.put("uemail",       user.getUemail());
        values.put("uphone",       user.getUphone());
        values.put("upassword",    user.getUpassword());
        values.put("upostalcode",  user.getUpostalcode());
        values.put("uaddress",     user.getUaddress());
        values.put("utype",        user.getUtype());
        values.put("ushopcount",   user.getUshopcount());

        long _uid = db.insert(TABLE_user, null, values);

        // updating row
        return db.update(TABLE_user, values, "uid = ?",
                new String[] { String.valueOf(user.getUid()) });
    }

    /**
     * @intro delete single user
     * @param userid
     */
    public void deleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_user, "uid = ?",
                new String[] { String.valueOf(userid) });
    }


    /**
     * @intro insert in to furniture table
     * @param user
     * @return
     */
    public long createFurniture(addfurniture user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fid",           user.getFid());
        values.put("fname",         user.getFname());
        values.put("ftype",         user.getFtype());
        values.put("fprice",        user.getFprice());
        values.put("fcolor",        user.getFcolor());
        values.put("ffabric",       user.getFfabric());
        values.put("fwood",         user.getFwood());
        values.put("fcount",        user.getFcount());
        values.put("fkosan",        user.getFkosan());
        values.put("fexist",        user.getFexist());
        values.put("fimageaddress", user.getFimageaddress());

        long userID = db.insert(TABLE_furniture, null, values);
        return userID;
    }

    /**
     * @intro select one furniture from database
     * @param fid
     * @return
     */
    public addfurniture getfurniture(int fid){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_furniture + " WHERE " +
                "fid  = " + fid;

        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        addfurniture furniture = new addfurniture();
        furniture.setFid            (c.getInt       (c.getColumnIndex("fid")));
        furniture.setFname          ((c.getString   (c.getColumnIndex("fname"))));
        furniture.setFtype          ((c.getString   (c.getColumnIndex("ftype"))));
        furniture.setFprice         ((c.getString   (c.getColumnIndex("fprice"))));
        furniture.setFcolor         ((c.getString   (c.getColumnIndex("fcolor"))));
        furniture.setFfabric        ((c.getString   (c.getColumnIndex("ffabric"))));
        furniture.setFwood          ((c.getString   (c.getColumnIndex("fwood"))));
        furniture.setFcount         ((c.getString   (c.getColumnIndex("fcount"))));
        furniture.setFkosan         ((c.getString   (c.getColumnIndex("fkosan"))));
        furniture.setFexist         ((c.getString   (c.getColumnIndex("fexist"))));
        furniture.setFimageaddress  ((c.getString   (c.getColumnIndex("fimageaddress"))));

        return furniture;
    }

    /**
     * @intro select all furnitures from furniture table
     * @return furnitures which is a list of the addfurniture class
     */
    public List<addfurniture> getAllFurnitures(){
        List<addfurniture> furnitures = new ArrayList<addfurniture>();
        String selectQuery = "SELECT * FROM furniture";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to furniture list
        if (c.moveToFirst()) {
            do{
                addfurniture furniture = new addfurniture();
                furniture.setFid            (c.getInt       (c.getColumnIndex("fid")));
                furniture.setFname          ((c.getString   (c.getColumnIndex("fname"))));
                furniture.setFtype          ((c.getString   (c.getColumnIndex("ftype"))));
                furniture.setFprice         ((c.getString   (c.getColumnIndex("fprice"))));
                furniture.setFcolor         ((c.getString   (c.getColumnIndex("fcolor"))));
                furniture.setFfabric        ((c.getString   (c.getColumnIndex("ffabric"))));
                furniture.setFwood          ((c.getString   (c.getColumnIndex("fwood"))));
                furniture.setFcount         ((c.getString   (c.getColumnIndex("fcount"))));
                furniture.setFkosan         ((c.getString   (c.getColumnIndex("fkosan"))));
                furniture.setFexist         ((c.getString   (c.getColumnIndex("fexist"))));
                furniture.setFimageaddress  ((c.getString   (c.getColumnIndex("fimageaddress"))));

                //adding to furnitures list
                furnitures.add(furniture);
            }while(c.moveToNext());
        }
        return furnitures;
    }

    /**
     * @intro update single furniture
     * @param furniture
     * @return Uid
     */
    public long updatefurniture(addfurniture furniture){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fname",             furniture.getFname());
        values.put("ftype",             furniture.getFtype());
        values.put("fprice",            furniture.getFprice());
        values.put("fcolor",            furniture.getFcolor());
        values.put("ffabric",           furniture.getFfabric());
        values.put("fwood",             furniture.getFwood());
        values.put("fcount",            furniture.getFcount());
        values.put("fkosan",            furniture.getFkosan());
        values.put("fexist",            furniture.getFexist());
        values.put("fimageaddress",     furniture.getFimageaddress());

        long fid = db.insert(TABLE_furniture, null, values);

        // updating row
        return db.update(TABLE_furniture, values, "fid = ?",
                new String[] { String.valueOf(furniture.getFid()) });
    }

    /**
     * @intro delete single furniture
     * @param fid
     */
    public void deleteFurniture(int fid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_furniture, "fid = ?",
                new String[] { String.valueOf(fid) });
    }
}
