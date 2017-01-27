package com.codeeaters.elitecard.database.entities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by leinad on 1/7/17.
 */

public class Arbre implements Parcelable {

    private static final String TAG = "Db-Arbre-Log";

    private long idArbre;
    private String codeArbre;
    private int age;
    private String region;
    private String prefecture;
    private String canton;
    private String village;
    private String origineSemence;
    private int choixMarquage;
    private Double hauteur;
    private Double rayonNord;
    private Double rayonSud;
    private Double rayonEst;
    private Double rayonOuest;
    private int couronneTaille;
    private String couronneEtalee;
    private String couronneCompacte;
    private String arbreRatatine;
    private Double ecratemementPied = 0.0;
    private Double diametreCouronneNordSud = 0.0;
    private Double diametreCouronneEstOuest = 0.0;
    private String observation = "";
    private Double longitude = 0.0;
    private Double latitude = 0.0;
    private long idProducteur;
    private String codeProducteur;

    public static final String TABLE = "arbres";

    public static final String ID_ARBRE_COLUMN = "id_arbre";
    public static final String CODE_ARBRE_COLUMN = "code_arbre";
    public static final String AGE_ARBRE_COLUMN = "age";
    public static final String REGION_COLUMN = "region_arbre";
    public static final String PREFECTURE_COLUMN = "prefecture_arbre";
    public static final String CANTON_COLUMN = "canton_arbre";
    public static final String VILLAGE_COLUMN = "village_arbre";
    public static final String ORIGINE_COLUMN = "origine_plan_semence";
    public static final String CHOIX_COLUMN = "choix_marquage";
    public static final String H_COLUMN = "hauteur";
    public static final String RN_COLUMN = "rayon_nord";
    public static final String RS_COLUMN = "rayon_sud";
    public static final String RE_COLUMN = "rayon_est";
    public static final String RO_COLUMN = "rayon_ouest";
    public static final String CT_COLUMN = "couronne_taille";
    public static final String CE_COLUMN = "couronne_etalee";
    public static final String CC_COLUMN = "couronne_compacte";
    public static final String AR_COLUMN = "arbre_ratatine";
    public static final String EP_COLUMN = "ecratemement_pied";
    public static final String DCNS_COLUMN = "diametre_couronne_nord_sud";
    public static final String DCEO_COLUMN = "diametre_couronne_est_ouest";
    public static final String OBS_COLUMN = "observation_arbre";
    public static final String LON_COLUMN = "longitude";
    public static final String LAT_COLUMN = "latitude";
    public static final String ID_PRODUCTEUR_COLUMN = "id_producteur";
    public static final String CODE_PRODUCTEUR_COLUMN = "code_producteur";

    public static final String[] COLUMNS = {ID_ARBRE_COLUMN, CODE_ARBRE_COLUMN, AGE_ARBRE_COLUMN,
            REGION_COLUMN, PREFECTURE_COLUMN, CANTON_COLUMN, VILLAGE_COLUMN, ORIGINE_COLUMN,
            CHOIX_COLUMN, H_COLUMN, RN_COLUMN, RS_COLUMN, RE_COLUMN, RO_COLUMN, CT_COLUMN,
            CE_COLUMN, CC_COLUMN, AR_COLUMN, EP_COLUMN, DCNS_COLUMN, DCEO_COLUMN, OBS_COLUMN,
            LON_COLUMN, LAT_COLUMN, ID_PRODUCTEUR_COLUMN, CODE_PRODUCTEUR_COLUMN};

    public static final String CREATE_ARBRE_TABLE = "CREATE TABLE "
            + TABLE + " (" + ID_ARBRE_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CODE_ARBRE_COLUMN + " TEXT NOT NULL UNIQUE, "
            + AGE_ARBRE_COLUMN + " INTEGER, "
            + REGION_COLUMN + " TEXT, "
            + PREFECTURE_COLUMN + " TEXT, "
            + CANTON_COLUMN + " TEXT, "
            + VILLAGE_COLUMN + " TEXT, "
            + ORIGINE_COLUMN + " TEXT, "
            + CHOIX_COLUMN + " INTEGER, "
            + H_COLUMN + " REAL, "
            + RN_COLUMN + " REAL, "
            + RS_COLUMN + " REAL, "
            + RE_COLUMN + " REAL, "
            + RO_COLUMN + " REAL, "
            + CT_COLUMN + " INTEGER, "
            + CE_COLUMN + " TEXT, "
            + CC_COLUMN + " TEXT, "
            + AR_COLUMN + " TEXT, "
            + EP_COLUMN + " REAL, "
            + DCNS_COLUMN + " REAL, "
            + DCEO_COLUMN + " REAL, "
            + OBS_COLUMN + " TEXT, "
            + LON_COLUMN + " REAL, "
            + LAT_COLUMN + " REAL, "
            + ID_PRODUCTEUR_COLUMN + " INTEGER, "
            + CODE_PRODUCTEUR_COLUMN + " TEXT, "
            + "FOREIGN KEY(" + ID_PRODUCTEUR_COLUMN + ") REFERENCES " + Producteur.TABLE + "(" + ID_PRODUCTEUR_COLUMN + "),"
            + "FOREIGN KEY(" + CODE_PRODUCTEUR_COLUMN + ") REFERENCES " + Producteur.TABLE + "(" + CODE_PRODUCTEUR_COLUMN + "))";

    public static final String DROP_PRODUCTEUR_TABLE = "DROP TABLE IF EXISTS " + TABLE;

    public static final String INSERT = "INSERT INTO arbres VALUES(1,'1-1-1-1',8,'aaze','azeaz','azea','azea','aze',1,23.0,2.0,3.0,4.0,3.0,1,'azee','aze',1,1.0,1,3,'azeze',56.0,56.0,1,'1-1-1');";
    public static final String INSERT1 = "INSERT INTO arbres VALUES(2,'1-1-1-2',3,'azer','aze','aze','aze','aze',2,23.0,23.0,12.0,12.0,12.0,1,'aze','aze',1,1.0,1,1,'aze',56.0,56.0,1,'1-1-1');";
    public static final String INSERT2 = "INSERT INTO arbres VALUES(3,'1-1-2-1',2,'aze','aze','aze','aze','aze',1,2.0,1.0,23.0,23.0,23.0,1,'aze','aze',0,1.0,1,2,'aze',56.0,56.0,2,'1-1-2');";
    public static final String INSERT3 = "INSERT INTO arbres VALUES(4,'1-1-2-2',2,'aze','aze','er','re','re',1,2.0,23.0,23.0,21.0,1.0,0,'aze','aze',0,1.0,2,1,'aze',56.0,56.0,2,'1-1-2');";
    public static final String INSERT4 = "INSERT INTO arbres VALUES(5,'1-1-1-3',1,'aze','zae','ear','era','aer',1,23.0,14.0,23.0,21.0,56.0,0,'aze','er',1,56.0,1,6,'azer',56.0,56.0,1,'1-1-1');";

    public Arbre() {
    }

    public Arbre(long idArbre, String codeArbre, int age, String region, String prefecture,
                 String canton, String village, String origineSemence, int choixMarquage,
                 Double hauteur, Double rayonNord, Double rayonSud, Double rayonEst,
                 Double rayonOuest, int couronneTaille, String couronneEtalee,
                 String couronneCompacte, String arbreRatatine, Double ecratemementPied,
                 Double diametreCouronneNordSud, Double diametreCouronneEstOuest,
                 String observation, Double longitude, Double latitude, long idProducteur,
                 String codeProducteur) {
        this.idArbre = idArbre;
        this.codeArbre = codeArbre;
        this.age = age;
        this.region = region;
        this.prefecture = prefecture;
        this.canton = canton;
        this.village = village;
        this.origineSemence = origineSemence;
        this.choixMarquage = choixMarquage;
        this.hauteur = hauteur;
        this.rayonNord = rayonNord;
        this.rayonSud = rayonSud;
        this.rayonEst = rayonEst;
        this.rayonOuest = rayonOuest;
        this.couronneTaille = couronneTaille;
        this.couronneEtalee = couronneEtalee;
        this.couronneCompacte = couronneCompacte;
        this.arbreRatatine = arbreRatatine;
        this.ecratemementPied = ecratemementPied;
        this.diametreCouronneNordSud = diametreCouronneNordSud;
        this.diametreCouronneEstOuest = diametreCouronneEstOuest;
        this.observation = observation;
        this.longitude = longitude;
        this.latitude = latitude;
        this.idProducteur = idProducteur;
        this.codeProducteur = codeProducteur;
    }

    protected Arbre(Parcel in) {
        idArbre = in.readLong();
        codeArbre = in.readString();
        age = in.readInt();
        region = in.readString();
        prefecture = in.readString();
        canton = in.readString();
        village = in.readString();
        origineSemence = in.readString();
        choixMarquage = in.readInt();
        hauteur = in.readDouble();
        rayonNord = in.readDouble();
        rayonSud = in.readDouble();
        rayonEst = in.readDouble();
        rayonOuest = in.readDouble();
        couronneTaille = in.readInt();
        couronneEtalee = in.readString();
        couronneCompacte = in.readString();
        arbreRatatine = in.readString();
        ecratemementPied = in.readDouble();
        diametreCouronneNordSud = in.readDouble();
        diametreCouronneEstOuest = in.readDouble();
        observation = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
        idProducteur = in.readLong();
        codeProducteur = in.readString();
    }

    public static final Creator<Arbre> CREATOR = new Creator<Arbre>() {
        @Override
        public Arbre createFromParcel(Parcel in) {
            return new Arbre(in);
        }

        @Override
        public Arbre[] newArray(int size) {
            return new Arbre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idArbre);
        dest.writeString(codeArbre);
        dest.writeInt(age);
        dest.writeString(region);
        dest.writeString(prefecture);
        dest.writeString(canton);
        dest.writeString(village);
        dest.writeString(origineSemence);
        dest.writeInt(choixMarquage);
        dest.writeDouble(hauteur);
        dest.writeDouble(rayonNord);
        dest.writeDouble(rayonSud);
        dest.writeDouble(rayonEst);
        dest.writeDouble(rayonOuest);
        dest.writeInt(couronneTaille);
        dest.writeString(couronneEtalee);
        dest.writeString(couronneCompacte);
        dest.writeString(arbreRatatine);
        dest.writeDouble(ecratemementPied);
        dest.writeDouble(diametreCouronneNordSud);
        dest.writeDouble(diametreCouronneEstOuest);
        dest.writeString(observation);
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeLong(idProducteur);
        dest.writeString(codeProducteur);
    }

    public static void createTable(SQLiteDatabase database) {
        Log.d(TAG, CREATE_ARBRE_TABLE);
        database.execSQL(CREATE_ARBRE_TABLE);

        Log.d(TAG, INSERT);
        database.execSQL(INSERT);

        Log.d(TAG, INSERT1);
        database.execSQL(INSERT1);

        Log.d(TAG, INSERT2);
        database.execSQL(INSERT2);

        Log.d(TAG, INSERT3);
        database.execSQL(INSERT3);

        Log.d(TAG, INSERT4);
        database.execSQL(INSERT4);
    }

    public static void dropTable(SQLiteDatabase database) {
        Log.d(TAG, DROP_PRODUCTEUR_TABLE);
        database.execSQL(DROP_PRODUCTEUR_TABLE);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getOrigineSemence() {
        return origineSemence;
    }

    public void setOrigineSemence(String origineSemence) {
        this.origineSemence = origineSemence;
    }

    public int getChoixMarquage() {
        return choixMarquage;
    }

    public void setChoixMarquage(int choixMarquage) {
        this.choixMarquage = choixMarquage;
    }

    public Double getHauteur() {
        return hauteur;
    }

    public void setHauteur(Double hauteur) {
        this.hauteur = hauteur;
    }

    public Double getRayonNord() {
        return rayonNord;
    }

    public void setRayonNord(Double rayonNord) {
        this.rayonNord = rayonNord;
    }

    public Double getRayonSud() {
        return rayonSud;
    }

    public void setRayonSud(Double rayonSud) {
        this.rayonSud = rayonSud;
    }

    public Double getRayonEst() {
        return rayonEst;
    }

    public void setRayonEst(Double rayonEst) {
        this.rayonEst = rayonEst;
    }

    public Double getRayonOuest() {
        return rayonOuest;
    }

    public void setRayonOuest(Double rayonOuest) {
        this.rayonOuest = rayonOuest;
    }

    public int getCouronneTaille() {
        return couronneTaille;
    }

    public void setCouronneTaille(int couronneTaille) {
        this.couronneTaille = couronneTaille;
    }

    public String getCouronneEtalee() {
        return couronneEtalee;
    }

    public void setCouronneEtalee(String couronneEtalee) {
        this.couronneEtalee = couronneEtalee;
    }

    public String getCouronneCompacte() {
        return couronneCompacte;
    }

    public void setCouronneCompacte(String couronneCompacte) {
        this.couronneCompacte = couronneCompacte;
    }

    public String getArbreRatatine() {
        return arbreRatatine;
    }

    public void setArbreRatatine(String arbreRatatine) {
        this.arbreRatatine = arbreRatatine;
    }

    public Double getEcratemementPied() {
        return ecratemementPied;
    }

    public void setEcratemementPied(Double ecratemementPied) {
        this.ecratemementPied = ecratemementPied;
    }

    public Double getDiametreCouronneNordSud() {
        return diametreCouronneNordSud;
    }

    public void setDiametreCouronneNordSud(Double diametreCouronneNordSud) {
        this.diametreCouronneNordSud = diametreCouronneNordSud;
    }

    public Double getDiametreCouronneEstOuest() {
        return diametreCouronneEstOuest;
    }

    public void setDiametreCouronneEstOuest(Double diametreCouronneEstOuest) {
        this.diametreCouronneEstOuest = diametreCouronneEstOuest;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
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

    @Override
    public String toString() {
        return "Arbre{" +
                "idArbre=" + idArbre +
                ", codeArbre='" + codeArbre + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", canton='" + canton + '\'' +
                ", village='" + village + '\'' +
                ", origineSemence='" + origineSemence + '\'' +
                ", choixMarquage=" + choixMarquage +
                ", hauteur=" + hauteur +
                ", rayonNord=" + rayonNord +
                ", rayonSud=" + rayonSud +
                ", rayonEst=" + rayonEst +
                ", rayonOuest=" + rayonOuest +
                ", couronneTaille=" + couronneTaille +
                ", couronneEtalee='" + couronneEtalee + '\'' +
                ", couronneCompacte='" + couronneCompacte + '\'' +
                ", arbreRatatine=" + arbreRatatine +
                ", ecratemementPied=" + ecratemementPied +
                ", diametreCouronneNordSud=" + diametreCouronneNordSud +
                ", diametreCouronneEstOuest=" + diametreCouronneEstOuest +
                ", observation='" + observation + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", idProducteur=" + idProducteur +
                ", codeProducteur='" + codeProducteur + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arbre arbre = (Arbre) o;

        if (idArbre != arbre.idArbre) return false;
        if (age != arbre.age) return false;
        if (choixMarquage != arbre.choixMarquage) return false;
        if (couronneTaille != arbre.couronneTaille) return false;
        if (arbreRatatine != arbre.arbreRatatine) return false;
        if (diametreCouronneNordSud != arbre.diametreCouronneNordSud) return false;
        if (diametreCouronneEstOuest != arbre.diametreCouronneEstOuest) return false;
        if (idProducteur != arbre.idProducteur) return false;
        if (codeArbre != null ? !codeArbre.equals(arbre.codeArbre) : arbre.codeArbre != null)
            return false;
        if (region != null ? !region.equals(arbre.region) : arbre.region != null) return false;
        if (prefecture != null ? !prefecture.equals(arbre.prefecture) : arbre.prefecture != null)
            return false;
        if (canton != null ? !canton.equals(arbre.canton) : arbre.canton != null) return false;
        if (village != null ? !village.equals(arbre.village) : arbre.village != null) return false;
        if (origineSemence != null ? !origineSemence.equals(arbre.origineSemence) : arbre.origineSemence != null)
            return false;
        if (hauteur != null ? !hauteur.equals(arbre.hauteur) : arbre.hauteur != null) return false;
        if (rayonNord != null ? !rayonNord.equals(arbre.rayonNord) : arbre.rayonNord != null)
            return false;
        if (rayonSud != null ? !rayonSud.equals(arbre.rayonSud) : arbre.rayonSud != null)
            return false;
        if (rayonEst != null ? !rayonEst.equals(arbre.rayonEst) : arbre.rayonEst != null)
            return false;
        if (rayonOuest != null ? !rayonOuest.equals(arbre.rayonOuest) : arbre.rayonOuest != null)
            return false;
        if (couronneEtalee != null ? !couronneEtalee.equals(arbre.couronneEtalee) : arbre.couronneEtalee != null)
            return false;
        if (couronneCompacte != null ? !couronneCompacte.equals(arbre.couronneCompacte) : arbre.couronneCompacte != null)
            return false;
        if (ecratemementPied != null ? !ecratemementPied.equals(arbre.ecratemementPied) : arbre.ecratemementPied != null)
            return false;
        if (observation != null ? !observation.equals(arbre.observation) : arbre.observation != null)
            return false;
        if (longitude != null ? !longitude.equals(arbre.longitude) : arbre.longitude != null)
            return false;
        if (latitude != null ? !latitude.equals(arbre.latitude) : arbre.latitude != null)
            return false;
        return codeProducteur != null ? codeProducteur.equals(arbre.codeProducteur) : arbre.codeProducteur == null;

    }

    @Override
    public int hashCode() {
        int result = (int) idArbre;
        result = 31 * result + (codeArbre != null ? codeArbre.hashCode() : 0);
        result = (int) (31 * result + idProducteur);
        result = 31 * result + (codeProducteur != null ? codeProducteur.hashCode() : 0);
        return result;
    }
}
