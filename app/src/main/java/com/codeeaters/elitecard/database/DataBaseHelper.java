package com.codeeaters.elitecard.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;


/**
 * Created by leinad on 1/11/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "Db-helper-Log";
    private static final String DATABASE_NAME = "elitecard.db";
    private static final int DATABASE_VERSION = 1;

    private static DataBaseHelper dataBaseHelperInstance;

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (dataBaseHelperInstance == null)
            dataBaseHelperInstance = new DataBaseHelper(context);
        return dataBaseHelperInstance;
    }

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            Log.d(TAG, "PRAGMA foreign_keys=ON;");
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Create Table Producteur");
        Producteur.createTable(db);
        Log.d(TAG, "Create Table Arbre");
        Arbre.createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version "
                + oldVersion + " to "
                + newVersion + " which destroys all old data");

        Log.d(TAG, "Drop Table Arbre");
        Arbre.dropTable(db);

        Log.d(TAG, "Drop Table Producteur");
        Producteur.dropTable(db);

        Log.d(TAG, "Create Table Producteur");
        Producteur.createTable(db);

        Log.d(TAG, "Create Table Arbre");
        Arbre.createTable(db);
    }
}
