package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 6:23 AM.
 */

public class Recolte {
    private static final String TAG = "Db-Visite-Recolte-Log";

    private long idvisiteRecolte;
    private String codeRecolte;
    private String tauxAmande;
    private String dateRecolte;
    private int depilliculage;
    private int formeDesNoix;
    private int separationNoixPommes;
    private double rendement;
    private String obs;
    private long idArbre;
    private String codeArbre;
    private ArrayList<PhotoRecolte> photoRecoltes;

    public static final String TABLE = "recoltes";
    public static final String ID_RECOLTES_COLUMN = "id_visite_recolte";
    public static final String CODE_RECOLTES_COLUMN = "code_recolte";
    public static final String TAUX_COLUMN = "taux";
    public static final String DATE_COLUMN = "date";
    public static final String DEPILLICULAGE_COLUMN = "depilliculage";
    public static final String FORME_NOIX_COLUMN = "forme_noix";
    public static final String SEPARATION_NOIX_POMMES_COLUMN = "separation";
    public static final String OBS_COLUMN = "obs";
    public static final String ID_ARBRE_COLUMN = "id_arbre";
    public static final String CODE_ARBRE_COLUMN = "code_arbre";

    public static final String[] COLUMNS = {ID_RECOLTES_COLUMN, CODE_RECOLTES_COLUMN,
            TAUX_COLUMN, DATE_COLUMN, DEPILLICULAGE_COLUMN, FORME_NOIX_COLUMN, SEPARATION_NOIX_POMMES_COLUMN, OBS_COLUMN, ID_ARBRE_COLUMN, CODE_ARBRE_COLUMN};

    public static final String CREATE_VISITE_FLORAISON_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_RECOLTES_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CODE_RECOLTES_COLUMN + " TEXT NOT NULL UNIQUE, "
            + TAUX_COLUMN + " TEXT, "
            + DATE_COLUMN + " TEXT, "
            + DEPILLICULAGE_COLUMN + " INTEGER, "
            + FORME_NOIX_COLUMN + " INTEGER, "
            + SEPARATION_NOIX_POMMES_COLUMN + " INTEGER, "
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

    public Recolte() {
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

    public String getTauxAmande() {
        return tauxAmande;
    }

    public void setTauxAmande(String tauxAmande) {
        this.tauxAmande = tauxAmande;
    }

    public String getDateRecolte() {
        return dateRecolte;
    }

    public void setDateRecolte(String dateRecolte) {
        this.dateRecolte = dateRecolte;
    }

    public int getDepilliculage() {
        return depilliculage;
    }

    public void setDepilliculage(int depilliculage) {
        this.depilliculage = depilliculage;
    }

    public int getFormeDesNoix() {
        return formeDesNoix;
    }

    public void setFormeDesNoix(int formeDesNoix) {
        this.formeDesNoix = formeDesNoix;
    }

    public int getSeparationNoixPommes() {
        return separationNoixPommes;
    }

    public void setSeparationNoixPommes(int separationNoixPommes) {
        this.separationNoixPommes = separationNoixPommes;
    }

    public double getRendement() {
        return rendement;
    }

    public void setRendement(double rendement) {
        this.rendement = rendement;
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

    public ArrayList<PhotoRecolte> getPhotoRecolte() {
        return photoRecoltes;
    }

    public void setPhotoRecolte(ArrayList<PhotoRecolte> photosRecoltes) {
        this.photoRecoltes = photosRecoltes;
    }
}
