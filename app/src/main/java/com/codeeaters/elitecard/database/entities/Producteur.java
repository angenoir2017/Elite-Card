package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leinad on 1/7/17.
 */

public class Producteur implements Parcelable {

    private static final String TAG = "Db-Producteur-Log";

    private long idProducteur;
    private String codeProducteur;
    private String region;
    private String prefecture;
    private String canton;
    private String village;
    private int age;
    private String sexe;
    private String observation;
    private String codeAgent;
    private int sequence;
    private ArrayList<Arbre> arbres = new ArrayList<>();

    public static final String TABLE = "producteurs";

    public static final String ID_PRODUCTEUR_COLUMN = "id_producteur";
    public static final String CODE_PRODUCTEUR_COLUMN = "code_producteur";
    public static final String REGION_COLUMN = "region_producteur";
    public static final String PREFECTURE_COLUMN = "prefecture_producteur";
    public static final String CANTON_COLUMN = "canton_producteur";
    public static final String VILLAGE_COLUMN = "village_producteur";
    public static final String AGE_PRODUCTEUR_COLUMN = "age_producteur";
    public static final String SEXE_COLUMN = "sexe";
    public static final String OBS_COLUMN = "observation_producteur";
    public static final String CODE_AGENT_COLUMN = "code_agent";
    public static final String SEQUENCE_COLUMN = "sequence";

    public static final String[] COLUMNS = {ID_PRODUCTEUR_COLUMN, CODE_PRODUCTEUR_COLUMN,
            REGION_COLUMN, PREFECTURE_COLUMN, CANTON_COLUMN, VILLAGE_COLUMN, AGE_PRODUCTEUR_COLUMN,
            SEXE_COLUMN, OBS_COLUMN, CODE_AGENT_COLUMN, SEQUENCE_COLUMN};

    public static final String CREATE_PRODUCTEUR_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_PRODUCTEUR_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CODE_PRODUCTEUR_COLUMN + " TEXT NOT NULL UNIQUE, "
            + REGION_COLUMN + " TEXT, "
            + PREFECTURE_COLUMN + " TEXT, "
            + CANTON_COLUMN + " TEXT, "
            + VILLAGE_COLUMN + " TEXT, "
            + AGE_PRODUCTEUR_COLUMN + " INTEGER, "
            + SEXE_COLUMN + " TEXT, "
            + OBS_COLUMN + " TEXT, "
            + CODE_AGENT_COLUMN + " TEXT, "
            + SEQUENCE_COLUMN + " INTEGER )";

    public static final String DROP_PRODUCTEUR_TABLE = "DROP TABLE IF EXISTS "+ TABLE;

    public static final String INSERT = "INSERT INTO producteurs VALUES(1, '1-1-1','rrtttyuii','erty','tyuio','etry',23,'M','azet', '1-1', 3);";
    public static final String INSERT1 = "INSERT INTO producteurs VALUES(2, '1-1-2','aze','aze','aze','aze',23,'F','aze', '1-1', 2);";

    public Producteur() {
    }

    public Producteur(long idProducteur, String codeProducteur, String region, String prefecture,
                      String canton, String village, int age_arbre, String sexe,
                      String observation, String codeAgent, int sequence) {
        this.idProducteur = idProducteur;
        this.codeProducteur = codeProducteur;
        this.region = region;
        this.prefecture = prefecture;
        this.canton = canton;
        this.village = village;
        this.age = age_arbre;
        this.sexe = sexe;
        this.observation = observation;
        this.codeAgent = codeAgent;
        this.sequence = sequence;
    }

    protected Producteur(Parcel in) {
        idProducteur = in.readLong();
        codeProducteur = in.readString();
        region = in.readString();
        prefecture = in.readString();
        canton = in.readString();
        village = in.readString();
        age = in.readInt();
        sexe = in.readString();
        observation = in.readString();
        codeAgent = in.readString();
        sequence = in.readInt();
    }

    public static final Creator<Producteur> CREATOR = new Creator<Producteur>() {
        @Override
        public Producteur createFromParcel(Parcel in) {
            return new Producteur(in);
        }

        @Override
        public Producteur[] newArray(int size) {
            return new Producteur[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idProducteur);
        dest.writeString(codeProducteur);
        dest.writeString(region);
        dest.writeString(prefecture);
        dest.writeString(canton);
        dest.writeString(village);
        dest.writeInt(age);
        dest.writeString(sexe);
        dest.writeString(observation);
        dest.writeString(codeAgent);
        dest.writeInt(sequence);
    }

    public static void createTable(SQLiteDatabase database){
        Log.d(TAG, CREATE_PRODUCTEUR_TABLE);
        database.execSQL(CREATE_PRODUCTEUR_TABLE);

        Log.d(TAG, INSERT);
        database.execSQL(INSERT);

        Log.d(TAG, INSERT1);
        database.execSQL(INSERT1);
    }

    public static void dropTable(SQLiteDatabase database){
        Log.d(TAG, DROP_PRODUCTEUR_TABLE);
        database.execSQL(DROP_PRODUCTEUR_TABLE);
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public long getIdProducteur() {
        return idProducteur;
    }

    public void setIdProducteur(long idProducteur) {
        this.idProducteur = idProducteur;
    }

    public String getCodeProducteur() {
        return codeProducteur;
    }

    public void setCodeProducteur(String codeProducteur) {
        this.codeProducteur = codeProducteur;
    }

    public String getCodeAgent() {
        return codeAgent;
    }

    public void setCodeAgent(String codeAgent) {
        this.codeAgent = codeAgent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ArrayList<Arbre> getArbres() {
        return this.arbres;
    }

    public void setArbres(ArrayList<Arbre> arbres) {
        this.arbres = arbres;
    }

    public void addArbre(Arbre arbre) {
        this.arbres.add(arbre);
    }

    public void removeArbre(Arbre arbres) {
        this.arbres.remove(arbres);
    }

    @Override
    public String toString() {
        return "Producteur{" +
                "idProducteur=" + idProducteur +
                ", codeProducteur='" + codeProducteur + '\'' +
                ", region='" + region + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", canton='" + canton + '\'' +
                ", village='" + village + '\'' +
                ", age=" + age +
                ", sexe='" + sexe + '\'' +
                ", observation='" + observation + '\'' +
                ", codeAgent='" + codeAgent + '\'' +
                ", sequence=" + sequence +
                ", arbres=" + arbres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producteur that = (Producteur) o;

        if (idProducteur != that.idProducteur) return false;
        if (age != that.age) return false;
        if (!codeProducteur.equals(that.codeProducteur)) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (prefecture != null ? !prefecture.equals(that.prefecture) : that.prefecture != null)
            return false;
        if (canton != null ? !canton.equals(that.canton) : that.canton != null) return false;
        if (village != null ? !village.equals(that.village) : that.village != null) return false;
        if (sexe != null ? !sexe.equals(that.sexe) : that.sexe != null) return false;
        if (observation != null ? !observation.equals(that.observation) : that.observation != null)
            return false;
        if (!codeAgent.equals(that.codeAgent)) return false;
        return arbres != null ? arbres.equals(that.arbres) : that.arbres == null;

    }

    @Override
    public int hashCode() {
        int result = (int) idProducteur;
        result = 31 * result + codeProducteur.hashCode();
        result = 31 * result + codeAgent.hashCode();
        return result;
    }
}
