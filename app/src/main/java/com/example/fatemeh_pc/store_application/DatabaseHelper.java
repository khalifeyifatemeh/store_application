package com.example.fatemeh_pc.store_application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;
import android.hardware.SensorAdditionalInfo;
import android.util.Log;
import android.widget.Toast;

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
    private static final String TABLE_ufi       = "ufi";

    // Table Create Statements
    // user table create statement
    private static final String CREATE_TABLE_user = "CREATE TABLE " +
            TABLE_user + "(uid INTEGER PRIMARY KEY AUTOINCREMENT, uname TEXT , ulastname TEXT," +
            " uemail TEXT, uphone TEXT,upassword TEXT, upostalcode TEXT, uaddress TEXT, " +
            " utype TEXT, ushopcount INTEGER)";


    // furniture table create statement
    private static final String CREATE_TABLE_furniture = "CREATE TABLE " +
            TABLE_furniture + "( fid INTEGER PRIMARY KEY, fname TEXT, ftype TEXT," +
            " fprice TEXT, fcolor TEXT, ffabric TEXT, fwood TEXT, fkosan TEXT, " +
            " fexist TEXT, fimage TEXT)";

    // invoice table create statement
    private static final String CREATE_TABLE_invoice = "CREATE TABLE " +
            TABLE_invoice + "( iid INTEGER PRIMARY KEY AUTOINCREMENT, itransactionid INTEGER , itotalprice INTEGER," +
            " itransportprice INTEGER, ioffprice INTEGER, idate TEXT)";

    // ufi table create statement
    private static final String CREATE_TABLE_ufi = "CREATE TABLE " +
            TABLE_ufi + "(uid INTEGER, fid INTEGER, iid INTEGER," +
            " PRIMARY KEY (uid, fid, iid))";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_user);
        db.execSQL(CREATE_TABLE_furniture);
        db.execSQL(CREATE_TABLE_invoice);
        db.execSQL(CREATE_TABLE_ufi);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_user);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_furniture);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_invoice);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ufi);

        // create new tables
        onCreate(db);
    }


    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
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
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("uname", user.getUname());
            values.put("ulastname", user.getUlastname());
            values.put("uemail", user.getUemail());
            values.put("uphone", user.getUphone());
            values.put("upassword", user.getUpassword());
            values.put("upostalcode", user.getUpostalcode());
            values.put("uaddress", user.getUaddress());
            values.put("utype", user.getUtype());
            values.put("ushopcount", user.getUshopcount());


            long userID = db.insert(TABLE_user, null, values);
            return userID;
        }catch (SQLException e){
            return 0;
        }

    }


    /**
     * @intro select specific user used in sign in class
     * @param uphone
     * @param upassword
     * @return adduser class
     */
    public adduser getUser(String uphone, String upassword){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_user + " WHERE " +
                    "uphone  = '" + uphone + "' and upassword  = '" + upassword + "'";

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
            user.setUid(c.getInt(c.getColumnIndex("uid")));
            user.setUname((c.getString(c.getColumnIndex("uname"))));
            user.setUlastname((c.getString(c.getColumnIndex("ulastname"))));
            user.setUemail((c.getString(c.getColumnIndex("uemail"))));
            user.setUphone((c.getString(c.getColumnIndex("uphone"))));
            user.setUpassword((c.getString(c.getColumnIndex("upassword"))));
            user.setUpostalcode((c.getString(c.getColumnIndex("upostalcode"))));
            user.setUaddress((c.getString(c.getColumnIndex("uaddress"))));
            user.setUtype((c.getString(c.getColumnIndex("utype"))));
            user.setUshopcount((c.getInt(c.getColumnIndex("ushopcount"))));

            return user;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro select all users from user table
     * @return users which is a list of the adduser class
     */
    public List<adduser> getAllUsers(){
        try {
            List<adduser> users = new ArrayList<adduser>();
            String selectQuery = "SELECT * FROM user";
            Log.e(LOG, selectQuery);

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to users list
            if (c.moveToFirst()) {
                do {
                    adduser user = new adduser();
                    user.setUid(c.getInt(c.getColumnIndex("uid")));
                    user.setUname((c.getString(c.getColumnIndex("uname"))));
                    user.setUlastname((c.getString(c.getColumnIndex("ulastname"))));
                    user.setUemail((c.getString(c.getColumnIndex("uemail"))));
                    user.setUphone((c.getString(c.getColumnIndex("uphone"))));
                    user.setUpassword((c.getString(c.getColumnIndex("upassword"))));
                    user.setUpostalcode((c.getString(c.getColumnIndex("upostalcode"))));
                    user.setUaddress((c.getString(c.getColumnIndex("uaddress"))));
                    user.setUtype((c.getString(c.getColumnIndex("utype"))));
                    user.setUshopcount((c.getInt(c.getColumnIndex("ushopcount"))));

                    //adding to users list
                    users.add(user);
                } while (c.moveToNext());
            }
            return users;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro update single user
     * @param user
     * @return Uid
     */
    public long updateUser(adduser user){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("uname", user.getUname());
            values.put("ulastname", user.getUlastname());
            values.put("uemail", user.getUemail());
            values.put("uphone", user.getUphone());
            values.put("upassword", user.getUpassword());
            values.put("upostalcode", user.getUpostalcode());
            values.put("uaddress", user.getUaddress());
            values.put("utype", user.getUtype());
            values.put("ushopcount", user.getUshopcount());

            long uid = db.update(TABLE_user, values, "uid = ?", new String[]{String.valueOf(user.getUid())});
            // updating row
            return uid;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro delete single user
     * @param userid
     */
    public void deleteUser(int userid){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_user, "uid = ?", new String[] {String.valueOf(userid)});
        } catch (SQLException e) {

        }
    }


    //**********************************************************************************************


    /**
     * @intro insert in to furniture table
     * @param user
     * @return
     */
    public long createFurniture(addfurniture user){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("fid", user.getFid());
            values.put("fname", user.getFname());
            values.put("ftype", user.getFtype());
            values.put("fprice", user.getFprice());
            values.put("fcolor", user.getFcolor());
            values.put("ffabric", user.getFfabric());
            values.put("fwood", user.getFwood());
            values.put("fcount", user.getFcount());
            values.put("fkosan", user.getFkosan());
            values.put("fexist", user.getFexist());
            values.put("fimageaddress", user.getFimageaddress());

            long userID = db.insert(TABLE_furniture, null, values);
            return userID;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro select one furniture from database
     * @param fid
     * @return
     */
    public addfurniture getfurniture(int fid){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_furniture + " WHERE " +
                    "fid  = " + fid;

            Log.e(LOG, selectQuery);
            Cursor c = db.rawQuery(selectQuery, null);

            if (c != null)
                c.moveToFirst();

            addfurniture furniture = new addfurniture();
            furniture.setFid(c.getInt(c.getColumnIndex("fid")));
            furniture.setFname((c.getString(c.getColumnIndex("fname"))));
            furniture.setFtype((c.getString(c.getColumnIndex("ftype"))));
            furniture.setFprice((c.getString(c.getColumnIndex("fprice"))));
            furniture.setFcolor((c.getString(c.getColumnIndex("fcolor"))));
            furniture.setFfabric((c.getString(c.getColumnIndex("ffabric"))));
            furniture.setFwood((c.getString(c.getColumnIndex("fwood"))));
            furniture.setFcount((c.getString(c.getColumnIndex("fcount"))));
            furniture.setFkosan((c.getString(c.getColumnIndex("fkosan"))));
            furniture.setFexist((c.getString(c.getColumnIndex("fexist"))));
            furniture.setFimageaddress((c.getString(c.getColumnIndex("fimageaddress"))));

            return furniture;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro select all furnitures from furniture table
     * @return furnitures which is a list of the addfurniture class
     */
    public List<addfurniture> getAllFurnitures(){
        try {
            List<addfurniture> furnitures = new ArrayList<addfurniture>();
            String selectQuery = "SELECT * FROM furniture";

            Log.e(LOG, selectQuery);

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to furniture list
            if (c.moveToFirst()) {
                do {
                    addfurniture furniture = new addfurniture();
                    furniture.setFid(c.getInt(c.getColumnIndex("fid")));
                    furniture.setFname((c.getString(c.getColumnIndex("fname"))));
                    furniture.setFtype((c.getString(c.getColumnIndex("ftype"))));
                    furniture.setFprice((c.getString(c.getColumnIndex("fprice"))));
                    furniture.setFcolor((c.getString(c.getColumnIndex("fcolor"))));
                    furniture.setFfabric((c.getString(c.getColumnIndex("ffabric"))));
                    furniture.setFwood((c.getString(c.getColumnIndex("fwood"))));
                    furniture.setFcount((c.getString(c.getColumnIndex("fcount"))));
                    furniture.setFkosan((c.getString(c.getColumnIndex("fkosan"))));
                    furniture.setFexist((c.getString(c.getColumnIndex("fexist"))));
                    furniture.setFimageaddress((c.getString(c.getColumnIndex("fimageaddress"))));

                    //adding to furnitures list
                    furnitures.add(furniture);
                } while (c.moveToNext());
            }
            return furnitures;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro update single furniture
     * @param furniture
     * @return fid
     */
    public long updatefurniture(addfurniture furniture){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("fname", furniture.getFname());
            values.put("ftype", furniture.getFtype());
            values.put("fprice", furniture.getFprice());
            values.put("fcolor", furniture.getFcolor());
            values.put("ffabric", furniture.getFfabric());
            values.put("fwood", furniture.getFwood());
            values.put("fcount", furniture.getFcount());
            values.put("fkosan", furniture.getFkosan());
            values.put("fexist", furniture.getFexist());
            values.put("fimageaddress", furniture.getFimageaddress());

            long fid = db.update(TABLE_furniture, values, "fid = ?",
                    new String[]{String.valueOf(furniture.getFid())});
            // updating row
            return fid;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro delete single furniture
     * @param fid
     */
    public void deleteFurniture(int fid){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_furniture, "fid = ?", new String[] {String.valueOf(fid)});
        } catch (SQLException e) {

        }
    }


    //**********************************************************************************************


    /**
     * @intro insert in to invoice table
     * @param invoice
     * @return
     */
    public long createInvoice(addinvoice invoice){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("itransactionid", invoice.getItransactionid());
            values.put("itotalprice", invoice.getItotalprice());
            values.put("itransportprice", invoice.getItransportprice());
            values.put("ioffprice", invoice.getIoffprice());
            values.put("idate", invoice.getIdate());


            long invoiceid = db.insert(TABLE_invoice, null, values);
            return invoiceid;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro select one invoice from invoice table
     * @param iid
     * @return
     */
    public addinvoice getinvoice(int iid){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_invoice + " WHERE " +
                    "iid  = " + iid;

            Log.e(LOG, selectQuery);
            Cursor c = db.rawQuery(selectQuery, null);

            if (c != null)
                c.moveToFirst();
            addinvoice invoice = new addinvoice();
            invoice.setIid(c.getInt(c.getColumnIndex("iid")));
            invoice.setItransactionid(c.getInt(c.getColumnIndex("itransactionid")));
            invoice.setItotalprice(c.getInt(c.getColumnIndex("itotalprice")));
            invoice.setItransportprice(c.getInt(c.getColumnIndex("itransportprice")));
            invoice.setIoffprice(c.getInt(c.getColumnIndex("ioffprice")));
            invoice.setIdate((c.getString(c.getColumnIndex("idate"))));

            return invoice;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro select all in invoices from invoice table
     * @return invoices which is a list of the addinvoice class
     */
    public List<addinvoice> getAllInvoices(){
        try {
            List<addinvoice> invoices = new ArrayList<addinvoice>();
            String selectQuery = "SELECT * FROM invoice";
            Log.e(LOG, selectQuery);

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to invoice list
            if (c.moveToFirst()) {
                do {
                    addinvoice invoice = new addinvoice();
                    invoice.setIid(c.getInt(c.getColumnIndex("iid")));
                    invoice.setItransactionid(c.getInt(c.getColumnIndex("itransactionid")));
                    invoice.setItotalprice(c.getInt(c.getColumnIndex("itotalprice")));
                    invoice.setItransportprice(c.getInt(c.getColumnIndex("itransportprice")));
                    invoice.setIoffprice(c.getInt(c.getColumnIndex("ioffprice")));
                    invoice.setIdate((c.getString(c.getColumnIndex("idate"))));

                    //adding to invoices list
                    invoices.add(invoice);
                } while (c.moveToNext());
            }
            return invoices;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro update single invoice
     * @param invoice
     * @return fid
     */
    public long updateinvoice(addinvoice invoice){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("itransactionid", invoice.getItransactionid());
            values.put("itotalprice", invoice.getItotalprice());
            values.put("itransportprice", invoice.getItransportprice());
            values.put("ioffprice", invoice.getIoffprice());
            values.put("idate", invoice.getIdate());

            // updating row
            long itid = db.update(TABLE_invoice, values, "iid = ?",
                    new String[]{String.valueOf(invoice.getIid())});
            return itid;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro delete single invoice
     * @param iid
     */
    public void deleteinvoice(int iid){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_invoice, "iid = ?", new String[] {String.valueOf(iid)});
        } catch (SQLException e) {

        }
    }

    //**********************************************************************************************

    /**
     * @intro insert in to ufi table
     * @param ufi
     * @return
     */
    public long createufi(addufi ufi){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("uid", ufi.getUid());
            values.put("fid", ufi.getFid());
            values.put("iid", ufi.getIid());

            long rownum = db.insert(TABLE_ufi, null, values);
            return rownum;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro select one ufi from ufi table
     * @param iid
     * @return
     */
    public addufi getufi(int iid){
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT * FROM " + TABLE_ufi + " WHERE " +
                    "iid  = " + iid;

            Log.e(LOG, selectQuery);
            Cursor c = db.rawQuery(selectQuery, null);

            if (c != null)
                c.moveToFirst();
            addufi ufi = new addufi();
            ufi.setUid(c.getInt(c.getColumnIndex("uid")));
            ufi.setFid(c.getInt(c.getColumnIndex("fid")));
            ufi.setIid(c.getInt(c.getColumnIndex("iid")));

            return ufi;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro select all in ufi from ufi table
     * @return ufis which is a list of the addufi class
     */
    public List<addufi> getAllUfi(){
        try {
            List<addufi> ufis = new ArrayList<addufi>();
            String selectQuery = "SELECT * FROM ufi";
            Log.e(LOG, selectQuery);

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to ufi list
            if (c.moveToFirst()) {
                do {
                    addufi ufi = new addufi();
                    ufi.setUid(c.getInt(c.getColumnIndex("uid")));
                    ufi.setFid(c.getInt(c.getColumnIndex("fid")));
                    ufi.setIid(c.getInt(c.getColumnIndex("iid")));
                    //adding to ufis list
                    ufis.add(ufi);
                } while (c.moveToNext());
            }
            return ufis;
        }catch (SQLException e){
            return null;
        }
    }

    /**
     * @intro update single ufi
     * @param ufi
     * @return fid
     */
    public long updateufi(addufi ufi){
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("uid", ufi.getUid());
            values.put("fid", ufi.getFid());
            values.put("iid", ufi.getIid());

            // updating row
            long iid = db.update(TABLE_ufi, values, "iid = ?",
                    new String[]{String.valueOf(ufi.getIid())});
            return iid;
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * @intro delete single ufi
     * @param iid
     */
    public void deleteufi(int iid){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_ufi, "iid = ?", new String[] {String.valueOf(iid)});
        } catch (SQLException e) {

        }
    }



}
