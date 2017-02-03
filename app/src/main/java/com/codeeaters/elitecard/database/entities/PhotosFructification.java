package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by leinad on 2/3/17 6:22 AM.
 */

public class PhotosFructification {

    private static final String TAG = "Db-Photo-Fructific*-Log";

    private long idPhotos;
    private Bitmap photo;
    private long idvisiteFructification;
    private String codeFructification;

    public static final String TABLE = "photo_fructification";
    public static final String ID_PHOTO_FLORAISON_COLUMN = "id_photo_fructification";
    public static final String PHOTO_COLUMN = "photo";
    public static final String ID_FRUCTIFICATION_COLUMN = "id_visite_fructification";
    public static final String CODE_FRUCTIFICATION_COLUMN = "code_fructification";

    public static final String[] COLUMNS = {ID_PHOTO_FLORAISON_COLUMN,
            PHOTO_COLUMN, ID_FRUCTIFICATION_COLUMN, CODE_FRUCTIFICATION_COLUMN};

    public static final String CREATE_PHOTO_FLORAISON_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_PHOTO_FLORAISON_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PHOTO_COLUMN + " BLOB, "
            + ID_FRUCTIFICATION_COLUMN + " INTEGER, "
            + CODE_FRUCTIFICATION_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_FRUCTIFICATION_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + ID_FRUCTIFICATION_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_FRUCTIFICATION_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + CODE_FRUCTIFICATION_COLUMN + "))";

    public static final String DROP_PHOTO_FLORAISON_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_PHOTO_FLORAISON_TABLE);
        database.execSQL(CREATE_PHOTO_FLORAISON_TABLE);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_PHOTO_FLORAISON_TABLE);
        database.execSQL(DROP_PHOTO_FLORAISON_TABLE);
    }

    public PhotosFructification() {
    }

    public long getIdPhotos() {
        return idPhotos;
    }

    public void setIdPhotos(long idPhotos) {
        this.idPhotos = idPhotos;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public long getIdvisiteFructification() {
        return idvisiteFructification;
    }

    public void setIdvisiteFructification(long idvisiteFructification) {
        this.idvisiteFructification = idvisiteFructification;
    }

    public String getCodeFructification() {
        return codeFructification;
    }

    public void setCodeFructification(String codeFructification) {
        this.codeFructification = codeFructification;
    }
}
