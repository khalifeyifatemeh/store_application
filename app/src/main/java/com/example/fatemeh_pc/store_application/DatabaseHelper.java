package com.example.fatemeh_pc.store_application;
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
    private static final String TABLE_customer  = "customer";
    private static final String TABLE_furniture = "furniture";
    private static final String TABLE_invoice   = "invoice";
    private static final String TABLE_cfi       = "cfi";

    // Table Create Statements
    // customer table create statement
    private static final String CREATE_TABLE_customer = "CREATE TABLE " +
            TABLE_customer + "( cid TEXT PRIMARY KEY, cname TEXT, clastname TEXT," +
            " cemail TEXT, cphone TEXT,cpassword TEXT, cpostalcode TEXT, caddress TEXT, " +
            " ctype TEXT, cshopcount INTEGER)";

    // furniture table create statement
    private static final String CREATE_TABLE_furniture = "CREATE TABLE " +
            TABLE_furniture + "( fid TEXT PRIMARY KEY, fname TEXT, ftype TEXT," +
            " fprice TEXT, fcolor TEXT, ffabric TEXT, fwood TEXT, fkosan TEXT, " +
            " fexist TEXT, fimage TEXT)";

    // invoice table create statement
    private static final String CREATE_TABLE_invoice = "CREATE TABLE " +
            TABLE_invoice + "( itransactionid INTEGER PRIMARY KEY, itotalprice INTEGER," +
            " itransportprice INTEGER, ioffprice INTEGER, idate DATETIME)";

    // invoice table create statement
    private static final String CREATE_TABLE_cfi = "CREATE TABLE " +
            TABLE_cfi + "(cid TEXT, fid TEXT, itransactionid INTEGER," +
            " PRIMARY KEY (cid, fid, itransactionid))";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_customer);
        db.execSQL(CREATE_TABLE_furniture);
        db.execSQL(CREATE_TABLE_invoice);
        db.execSQL(CREATE_TABLE_cfi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_customer);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_furniture);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_invoice);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_cfi);

        // create new tables
        onCreate(db);
    }

}
