package com.example.fatemeh_pc.store_application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "moblplus.db";

    // Table Names
    private static final String TABLE_user  = "user";
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
     *
     * @param _adduser
     * @return long
     * @description insert user to user table
     */
    public long createUser(adduser _adduser){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("uname",        _adduser.getUname());
        values.put("ulastname",    _adduser.getUlastname());
        values.put("uemail",       _adduser.getUemail());
        values.put("uphone",       _adduser.getUphone());
        values.put("upassword",    _adduser.getUpassword());
        values.put("upostalcode",  _adduser.getUpostalcode());
        values.put("uaddress",     _adduser.getUaddress());
        values.put("utype",        _adduser.getUtype());
        values.put("ushopcount",   _adduser.getUshopcount());

        long _uid = db.insert(TABLE_user, null, values);

        return _uid;
    }

    public adduser getuser()
    {

    }
}
