package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by leinad on 2/2/17 8:16 AM.
 */

public class PhotosFloraison {

    private static final String TAG = "Db-Photo-Floraison-Log";

    private long idPhotos;
    private Bitmap photo;
    private long idvisiteFloraison;
    private String codeFloraison;

    public static final String TABLE = "photo_floraison";
    public static final String ID_PHOTO_FLORAISON_COLUMN = "id_photo_floraison";
    public static final String PHOTO_COLUMN = "photo";
    public static final String ID_FLORAISON_COLUMN = "id_visite_floraison";
    public static final String CODE_FLORAISON_COLUMN = "code_floraison";

    public static final String[] COLUMNS = {ID_PHOTO_FLORAISON_COLUMN,
            PHOTO_COLUMN, ID_FLORAISON_COLUMN, CODE_FLORAISON_COLUMN};

    public static final String CREATE_PHOTO_FLORAISON_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_PHOTO_FLORAISON_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PHOTO_COLUMN + " BLOB, "
            + ID_FLORAISON_COLUMN + " INTEGER, "
            + CODE_FLORAISON_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_FLORAISON_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + ID_FLORAISON_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_FLORAISON_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + CODE_FLORAISON_COLUMN + "))";

    public static final String DROP_PHOTO_FLORAISON_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public PhotosFloraison() {
    }

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_PHOTO_FLORAISON_TABLE);
        database.execSQL(CREATE_PHOTO_FLORAISON_TABLE);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_PHOTO_FLORAISON_TABLE);
        database.execSQL(DROP_PHOTO_FLORAISON_TABLE);
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

    public long getIdvisiteFloraison() {
        return idvisiteFloraison;
    }

    public void setIdvisiteFloraison(long idvisiteFloraison) {
        this.idvisiteFloraison = idvisiteFloraison;
    }

    public String getCodeFloraison() {
        return codeFloraison;
    }

    public void setCodeFloraison(String codeFloraison) {
        this.codeFloraison = codeFloraison;
    }
}
