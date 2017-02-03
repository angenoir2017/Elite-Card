package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by leinad on 2/3/17 6:23 AM.
 */

public class PhotosRecoltes {

    private static final String TAG = "Db-Photo-Recoltes-Log";

    private long idPhotos;
    private Bitmap photo;
    private long idvisiteRecolte;
    private String codeRecolte;

    public static final String TABLE = "photo_floraison";
    public static final String ID_PHOTO_RECOLTES_COLUMN = "id_photo_floraison";
    public static final String PHOTO_COLUMN = "photo";
    public static final String ID_RECOLTES_COLUMN = "id_visite_recolte";
    public static final String CODE_RECOLTES_COLUMN = "code_recolte";

    public static final String[] COLUMNS = {ID_PHOTO_RECOLTES_COLUMN,
            PHOTO_COLUMN, ID_RECOLTES_COLUMN, CODE_RECOLTES_COLUMN};

    public static final String CREATE_PHOTO_FLORAISON_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_PHOTO_RECOLTES_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PHOTO_COLUMN + " BLOB, "
            + ID_RECOLTES_COLUMN + " INTEGER, "
            + CODE_RECOLTES_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_RECOLTES_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + ID_RECOLTES_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_RECOLTES_COLUMN + ") REFERENCES " + VisiteFloraison.TABLE + "(" + CODE_RECOLTES_COLUMN + "))";

    public static final String DROP_PHOTO_FLORAISON_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_PHOTO_FLORAISON_TABLE);
        database.execSQL(CREATE_PHOTO_FLORAISON_TABLE);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_PHOTO_FLORAISON_TABLE);
        database.execSQL(DROP_PHOTO_FLORAISON_TABLE);
    }

    public PhotosRecoltes() {
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

    public long getIdvisiteRecolte() {
        return idvisiteRecolte;
    }

    public void setIdvisiteRecolte(long idvisiteRecolte) {
        this.idvisiteRecolte = idvisiteRecolte;
    }

    public String getCodeRecolte() {
        return codeRecolte;
    }

    public void setCodeRecolte(String codeRecolte) {
        this.codeRecolte = codeRecolte;
    }
}
