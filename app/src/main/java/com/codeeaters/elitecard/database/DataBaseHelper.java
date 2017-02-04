package com.codeeaters.elitecard.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.PhotoFloraison;
import com.codeeaters.elitecard.database.entities.PhotoFructification;
import com.codeeaters.elitecard.database.entities.PhotoRecolte;
import com.codeeaters.elitecard.database.entities.Producteur;
import com.codeeaters.elitecard.database.entities.Recolte;
import com.codeeaters.elitecard.database.entities.VisiteFloraison;
import com.codeeaters.elitecard.database.entities.VisiteFructification;


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

        Log.d(TAG, "Create Table Visite Floraison");
        VisiteFloraison.createTable(db);

        Log.d(TAG, "Create Table Photo Floraison");
        PhotoFloraison.createTable(db);

        Log.d(TAG, "Create Table Visite Fructification");
        VisiteFructification.createTable(db);

        Log.d(TAG, "Create Table Photo Fructification");
        PhotoFructification.createTable(db);

        Log.d(TAG, "Update Table Arbre Add Foreign Keys");
        Arbre.addForeignkeys(db);

        Log.d(TAG, "Create Table Recolte");
        Recolte.createTable(db);

        Log.d(TAG, "Create Table Photo Recolte");
        PhotoRecolte.createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version "
                + oldVersion + " to "
                + newVersion + " which destroys all old data");

        Log.d(TAG, "Drop Table Recolte");
        PhotoRecolte.dropTable(db);

        Log.d(TAG, "Drop Table Recolte");
        Recolte.dropTable(db);

        Log.d(TAG, "Drop Table Photo Fructification");
        PhotoFructification.dropTable(db);

        Log.d(TAG, "Drop Table Visite Fructification");
        VisiteFructification.dropTable(db);

        Log.d(TAG, "Drop Table Photo Floraison");
        PhotoFloraison.dropTable(db);

        Log.d(TAG, "Drop Table Visite Floraison");
        VisiteFloraison.dropTable(db);

        Log.d(TAG, "Drop Table Arbre");
        Arbre.dropTable(db);

        Log.d(TAG, "Drop Table Producteur");
        Producteur.dropTable(db);

        onCreate(db);
    }
}
