package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 6:21 AM.
 */

public class VisiteFructification {

    private static final String TAG = "Db-Visite-Fuctific*-Log";

    private long idvisiteFructification;
    private String codeFructification;
    private String densite;
    private int fructificationHomogene;
    private int maturiteRapideHomogene;
    private int fruitMelangeFleurs;
    private String obs;
    private long idArbre;
    private String codeArbre;
    private ArrayList<PhotoFructification> photoFructification;

    public static final String TABLE = "visite_fructification";
    public static final String ID_FRUCTIFICATION_COLUMN = "id_visite_fructification";
    public static final String CODE_FRUCTIFICATION_COLUMN = "code_fructification";
    public static final String DENSITE_COLUMN = "densite";
    public static final String FRUCTIFICATION_HOMOGENE_COLUMN = "fructification_homogene";
    public static final String MATURITE_RAPIDE_HOMOGENE_COLUMN = "maturite_rapide";
    public static final String FRUIT_MELANGE_FLEUR_COLUMN = "fruit_melange";
    public static final String OBS_COLUMN = "obs";
    public static final String ID_ARBRE_COLUMN = "id_arbre";
    public static final String CODE_ARBRE_COLUMN = "code_arbre";

    public static final String[] COLUMNS = {ID_FRUCTIFICATION_COLUMN, CODE_FRUCTIFICATION_COLUMN,
            DENSITE_COLUMN, FRUCTIFICATION_HOMOGENE_COLUMN, MATURITE_RAPIDE_HOMOGENE_COLUMN, FRUIT_MELANGE_FLEUR_COLUMN, OBS_COLUMN, ID_ARBRE_COLUMN, CODE_ARBRE_COLUMN};

    public static final String CREATE_VISITE_FLORAISON_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_FRUCTIFICATION_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CODE_FRUCTIFICATION_COLUMN + " TEXT NOT NULL UNIQUE, "
            + DENSITE_COLUMN + " TEXT, "
            + FRUCTIFICATION_HOMOGENE_COLUMN + " INTEGER, "
            + MATURITE_RAPIDE_HOMOGENE_COLUMN + " INTEGER, "
            + FRUIT_MELANGE_FLEUR_COLUMN + " INTEGER, "
            + OBS_COLUMN + " TEXT, "
            + ID_ARBRE_COLUMN + " INTEGER, "
            + CODE_ARBRE_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_ARBRE_COLUMN + ") REFERENCES " + Arbre.TABLE + "(" + ID_ARBRE_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_ARBRE_COLUMN + ") REFERENCES " + Arbre.TABLE + "(" + CODE_ARBRE_COLUMN + "))";

    public static final String DROP_VISITE_FLORAISON_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_VISITE_FLORAISON_TABLE);
        database.execSQL(CREATE_VISITE_FLORAISON_TABLE);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_VISITE_FLORAISON_TABLE);
        database.execSQL(DROP_VISITE_FLORAISON_TABLE);
    }

    public VisiteFructification() {
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

    public String getDensite() {
        return densite;
    }

    public void setDensite(String densite) {
        this.densite = densite;
    }

    public int getFructificationHomogene() {
        return fructificationHomogene;
    }

    public void setFructificationHomogene(int fructificationHomogene) {
        this.fructificationHomogene = fructificationHomogene;
    }

    public int getMaturiteRapideHomogene() {
        return maturiteRapideHomogene;
    }

    public void setMaturiteRapideHomogene(int maturiteRapideHomogene) {
        this.maturiteRapideHomogene = maturiteRapideHomogene;
    }

    public int getFruitMelangeFleurs() {
        return fruitMelangeFleurs;
    }

    public void setFruitMelangeFleurs(int fruitMelangeFleurs) {
        this.fruitMelangeFleurs = fruitMelangeFleurs;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
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

    public ArrayList<PhotoFructification> getPhotoFructification() {
        return photoFructification;
    }

    public void setPhotoFructification(ArrayList<PhotoFructification> photoFructification) {
        this.photoFructification = photoFructification;
    }
}
