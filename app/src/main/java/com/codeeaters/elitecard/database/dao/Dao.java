package com.codeeaters.elitecard.database.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.codeeaters.elitecard.database.DataBaseHelper;


/**
 * Created by leinad on 1/11/17.
 */

public class Dao {

    protected SQLiteDatabase db;
    private DataBaseHelper dbHelper;
    private Context mContext;

    public Dao(Context context) {
        this.mContext = context;
        dbHelper = DataBaseHelper.getHelper(mContext);
        open();
    }

    public void open() throws SQLException {
        if(dbHelper == null){
            dbHelper = DataBaseHelper.getHelper(mContext);
        }

        db = dbHelper.getWritableDatabase();
//        dbHelper.onUpgrade(db, 1, 2);
    }
}
