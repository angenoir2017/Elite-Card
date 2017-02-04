package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leinad on 2/2/17 8:02 AM.
 */

public class VisiteFloraison {

    private static final String TAG = "Db-Visite-Floraison-Log";

    private long idvisiteFloraison;
    private String codeFloraison;
    private String tauxAbondance;
    private String dateFloraison;
    private long idArbre;
    private String codeArbre;
    private ArrayList<PhotoFloraison> photoFloraisons;

    public static final String TABLE = "visites_floraison";
    public static final String ID_FLORAISON_COLUMN = "id_visite_floraison";
    public static final String CODE_FLORAISON_COLUMN = "code_floraison";
    public static final String TAUX_COLUMN = "taux_abondance";
    public static final String DATE_COLUMN = "date";
    public static final String ID_ARBRE_COLUMN = "id_arbre";
    public static final String CODE_ARBRE_COLUMN = "code_arbre";

    public static final String[] COLUMNS = {ID_FLORAISON_COLUMN,
            CODE_FLORAISON_COLUMN, TAUX_COLUMN, DATE_COLUMN, ID_ARBRE_COLUMN, CODE_ARBRE_COLUMN};

    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_FLORAISON_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CODE_FLORAISON_COLUMN + " TEXT NOT NULL UNIQUE, "
            + TAUX_COLUMN + " TEXT, "
            + DATE_COLUMN + " TEXT, "
            + ID_ARBRE_COLUMN + " INTEGER, "
            + CODE_ARBRE_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_ARBRE_COLUMN + ") REFERENCES " + Arbre.TABLE + "(" + ID_ARBRE_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_ARBRE_COLUMN + ") REFERENCES " + Arbre.TABLE + "(" + CODE_ARBRE_COLUMN + "))";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public VisiteFloraison() {
    }

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_TABLE);
        database.execSQL(CREATE_TABLE);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_TABLE);
        database.execSQL(DROP_TABLE);
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

    public String getTauxAbondance() {
        return tauxAbondance;
    }

    public void setTauxAbondance(String tauxAbondance) {
        this.tauxAbondance = tauxAbondance;
    }

    public String getDateFloraison() {
        return dateFloraison;
    }

    public void setDateFloraison(String dateFloraison) {
        this.dateFloraison = dateFloraison;
    }

    public long getIdArbre() {
        return idArbre;
    }

    public void setIdArbre(long idArbre) {
        this.idArbre = idArbre;
    }

    public String getCodeArbre() {
        return codeArbre;
    }

    public void setCodeArbre(String codeArbre) {
        this.codeArbre = codeArbre;
    }

    public ArrayList<PhotoFloraison> getPhotoFloraisons() {
        return photoFloraisons;
    }

    public void setPhotoFloraisons(ArrayList<PhotoFloraison> photoFloraisons) {
        this.photoFloraisons = photoFloraisons;
    }
}
