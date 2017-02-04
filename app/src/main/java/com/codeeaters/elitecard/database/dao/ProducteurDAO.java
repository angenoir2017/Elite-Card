package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.Arbre;
import com.codeeaters.elitecard.database.entities.Producteur;

import java.util.ArrayList;

/**
 * Created by leinad on 1/7/17.
 */

public class ProducteurDAO extends DAO implements IDAO<Producteur> {

    private static final String TAG = "Producteur-DAO-Log";

    private String[] PRODUCTEUR_ARBRE_COLUMNS = {Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN,
            Producteur.TABLE + "." + Producteur.CODE_PRODUCTEUR_COLUMN,
            Producteur.TABLE + "." + Producteur.REGION_COLUMN,
            Producteur.TABLE + "." + Producteur.PREFECTURE_COLUMN,
            Producteur.TABLE + "." + Producteur.CANTON_COLUMN,
            Producteur.TABLE + "." + Producteur.VILLAGE_COLUMN,
            Producteur.TABLE + "." + Producteur.AGE_PRODUCTEUR_COLUMN,
            Producteur.TABLE + "." + Producteur.SEXE_COLUMN,
            Producteur.TABLE + "." + Producteur.OBS_COLUMN,
            Producteur.TABLE + "." + Producteur.CODE_AGENT_COLUMN,
            Producteur.TABLE + "." + Producteur.SEQUENCE_COLUMN,
            Arbre.TABLE + "." + Arbre.ID_ARBRE_COLUMN,
            Arbre.TABLE + "." + Arbre.CODE_ARBRE_COLUMN,
            Arbre.TABLE + "." + Arbre.AGE_ARBRE_COLUMN,
            Arbre.TABLE + "." + Arbre.REGION_COLUMN,
            Arbre.TABLE + "." + Arbre.PREFECTURE_COLUMN,
            Arbre.TABLE + "." + Arbre.CANTON_COLUMN,
            Arbre.TABLE + "." + Arbre.VILLAGE_COLUMN,
            Arbre.TABLE + "." + Arbre.ORIGINE_COLUMN,
            Arbre.TABLE + "." + Arbre.CHOIX_COLUMN,
            Arbre.TABLE + "." + Arbre.H_COLUMN,
            Arbre.TABLE + "." + Arbre.RN_COLUMN,
            Arbre.TABLE + "." + Arbre.RS_COLUMN,
            Arbre.TABLE + "." + Arbre.RE_COLUMN,
            Arbre.TABLE + "." + Arbre.RO_COLUMN,
            Arbre.TABLE + "." + Arbre.CT_COLUMN,
            Arbre.TABLE + "." + Arbre.CE_COLUMN,
            Arbre.TABLE + "." + Arbre.CC_COLUMN,
            Arbre.TABLE + "." + Arbre.AR_COLUMN,
            Arbre.TABLE + "." + Arbre.EP_COLUMN,
            Arbre.TABLE + "." + Arbre.DCNS_COLUMN,
            Arbre.TABLE + "." + Arbre.DCEO_COLUMN,
            Arbre.TABLE + "." + Arbre.OBS_COLUMN,
            Arbre.TABLE + "." + Arbre.LON_COLUMN,
            Arbre.TABLE + "." + Arbre.LAT_COLUMN,
            Arbre.TABLE + "." + Arbre.VISITE_FL_COLUMN,
            Arbre.TABLE + "." + Arbre.VISITE_FR_COLUMN,
            Arbre.TABLE + "." + Arbre.ID_PRODUCTEUR_COLUMN,
            Arbre.TABLE + "." + Arbre.CODE_PRODUCTEUR_COLUMN,
            Arbre.TABLE + "." + Arbre.ID_FLORAISON_COLUMN,
            Arbre.TABLE + "." + Arbre.CODE_FLORAISON_COLUMN,
            Arbre.TABLE + "." + Arbre.ID_FRUCTIFICATION_COLUMN,
            Arbre.TABLE + "." + Arbre.CODE_FRUCTIFICATION_COLUMN
    };

    public ProducteurDAO(Context context) {
        super(context);
    }

    @Override
    public Producteur add(Producteur entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Producteur.CODE_PRODUCTEUR_COLUMN, entity.getCodeProducteur());
        contentValues.put(Producteur.REGION_COLUMN, entity.getRegion());
        contentValues.put(Producteur.PREFECTURE_COLUMN, entity.getPrefecture());
        contentValues.put(Producteur.CANTON_COLUMN, entity.getCanton());
        contentValues.put(Producteur.VILLAGE_COLUMN, entity.getVillage());
        contentValues.put(Producteur.AGE_PRODUCTEUR_COLUMN, entity.getAge());
        contentValues.put(Producteur.SEXE_COLUMN, entity.getSexe());
        contentValues.put(Producteur.OBS_COLUMN, entity.getObservation());
        contentValues.put(Producteur.CODE_AGENT_COLUMN, entity.getCodeAgent());
        long result = db.insert(Producteur.TABLE, null, contentValues);
        entity.setIdProducteur(result);
        return entity;
    }

    @Override
    public ArrayList<Producteur> addMany(ArrayList<Producteur> entities) {
        ArrayList<Producteur> producteurs = new ArrayList<>();
        for (Producteur producteur : entities) {
            producteur = add(producteur);
            producteurs.add(producteur);
        }
        return producteurs;
    }

    @Override
    public boolean updateOne(Producteur entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<Producteur> entities) {
        return false;
    }

    @Override
    public boolean remove(Producteur entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<Producteur> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public Producteur fetchOne(int id) {
        Producteur producteur = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Producteur.TABLE);
        queryBuilder.appendWhere(Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(Producteur.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, Producteur.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            producteur = new Producteur();
            producteur = appendDataToProducteur(producteur, cursor);
        }
        return producteur;
    }

    @Override
    public ArrayList<Producteur> fetchAll() {
        Producteur producteur;
        ArrayList<Producteur> producteurs = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Producteur.TABLE);

        Log.d(TAG, queryBuilder.buildQuery(Producteur.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, Producteur.COLUMNS, null, null, null, null, null);
        producteurs = new ArrayList<>();
        while (cursor.moveToNext()) {
            producteur = new Producteur();
            producteur = appendDataToProducteur(producteur, cursor);
            producteurs.add(producteur);
        }
        return producteurs;
    }

    public Producteur fetchOneWithChild(int id) {
        Producteur producteur = null;
        Arbre arbre;

        String sortOrder = Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Producteur.TABLE + " INNER JOIN " + Arbre.TABLE + " ON "
                + Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN + "=" + Arbre.TABLE + "." + Arbre.ID_PRODUCTEUR_COLUMN);
        queryBuilder.appendWhere(Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(PRODUCTEUR_ARBRE_COLUMNS, null, null, null, sortOrder, null));

        Cursor cursor = queryBuilder.query(db, PRODUCTEUR_ARBRE_COLUMNS, null, null, null, null, sortOrder);
        if (cursor.moveToFirst()) {
            producteur = new Producteur();
            producteur = appendDataToProducteur(producteur, cursor);

            arbre = new Arbre();
            arbre = appendDataToArbre(arbre, cursor);

            producteur.addArbre(arbre);

            while (cursor.moveToNext()) {
                arbre = new Arbre();
                arbre = appendDataToArbre(arbre, cursor);

                producteur.addArbre(arbre);
            }
        }

        return producteur;
    }

    public ArrayList<Producteur> fetchAllWithChild() {
        Producteur producteur = null;
        Arbre arbre;
        ArrayList<Producteur> producteurs = null;

        String sortOrder = Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Producteur.TABLE + " INNER JOIN " + Arbre.TABLE + " ON "
                + Producteur.TABLE + "." + Producteur.ID_PRODUCTEUR_COLUMN + "=" + Arbre.TABLE + "." + Arbre.ID_PRODUCTEUR_COLUMN);

        Log.d(TAG, queryBuilder.buildQuery(PRODUCTEUR_ARBRE_COLUMNS, null, null, null, sortOrder, null));

        Cursor cursor = queryBuilder.query(db, PRODUCTEUR_ARBRE_COLUMNS, null, null, null, null, sortOrder);
        int currentRowId;

        if (cursor.moveToFirst()) {
            producteurs = new ArrayList<>();
            currentRowId = cursor.getInt(0);
            Log.d(TAG, "First Producteur " + cursor.getString(1));

            producteur = new Producteur();
            producteur = appendDataToProducteur(producteur, cursor);

            arbre = new Arbre();
            arbre = appendDataToArbre(arbre, cursor);
            producteur.addArbre(arbre);
            Log.d(TAG, producteur.getCodeProducteur() + " Producteur Arbres Size " + producteur.getArbres().size());

            while (cursor.moveToNext()) {
                if (cursor.getInt(0) == currentRowId) {
                    arbre = new Arbre();
                    arbre = appendDataToArbre(arbre, cursor);
                    producteur.addArbre(arbre);
                    Log.d(TAG, producteur.getCodeProducteur() + " Producteur Arbres Size " + producteur.getArbres().size());
                } else {
                    producteurs.add(producteur);
                    currentRowId = cursor.getInt(0);
                    Log.d(TAG, "Append New Producteur " + cursor.getString(1));

                    producteur = new Producteur();
                    producteur = appendDataToProducteur(producteur, cursor);

                    arbre = new Arbre();
                    arbre = appendDataToArbre(arbre, cursor);

                    producteur.addArbre(arbre);
                    Log.d(TAG, producteur.getCodeProducteur() + " Producteur Arbres Size " + producteur.getArbres().size());
                }
            }
        }

        if (producteurs != null) {
            producteurs.add(producteur);
        }
        return producteurs;
    }

    public Producteur updateSequence(Producteur producteur) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Producteur.SEQUENCE_COLUMN, (producteur.getSequence() + 1));

        String where = Producteur.ID_PRODUCTEUR_COLUMN + " = ?";
        String[] args = new String[]{producteur.getIdProducteur() + ""};

        db.update(Producteur.TABLE, contentValues, where, args);
        producteur.setSequence(producteur.getSequence() + 1);
        return producteur;
    }

    private Producteur appendDataToProducteur(Producteur producteur, Cursor cursor) {
        producteur.setIdProducteur(cursor.getLong(0));
        producteur.setCodeProducteur(cursor.getString(1));
        producteur.setRegion(cursor.getString(2));
        producteur.setPrefecture(cursor.getString(3));
        producteur.setCanton(cursor.getString(4));
        producteur.setVillage(cursor.getString(5));
        producteur.setAge(cursor.getInt(6));
        producteur.setSexe(cursor.getString(7));
        producteur.setObservation(cursor.getString(8));
        producteur.setCodeAgent(cursor.getString(9));
        producteur.setSequence(cursor.getInt(10));
        return producteur;
    }

    private Arbre appendDataToArbre(Arbre arbre, Cursor cursor) {
        arbre.setIdArbre(cursor.getLong(11));
        arbre.setCodeArbre(cursor.getString(12));
        Log.d(TAG, "Append Arbre " + cursor.getString(12));
        arbre.setAge(cursor.getInt(13));
        arbre.setRegion(cursor.getString(14));
        arbre.setPrefecture(cursor.getString(15));
        arbre.setCanton(cursor.getString(16));
        arbre.setVillage(cursor.getString(17));
        arbre.setOrigineSemence(cursor.getString(18));
        arbre.setChoixMarquage(cursor.getInt(19));
        arbre.setHauteur(cursor.getDouble(20));
        arbre.setRayonNord(cursor.getDouble(21));
        arbre.setRayonSud(cursor.getDouble(22));
        arbre.setRayonEst(cursor.getDouble(23));
        arbre.setRayonOuest(cursor.getDouble(24));
        arbre.setCouronneTaille(cursor.getInt(25));
        arbre.setCouronneEtalee(cursor.getString(26));
        arbre.setCouronneCompacte(cursor.getString(27));
        arbre.setArbreRatatine(cursor.getString(28));
        arbre.setEcratemementPied(cursor.getDouble(29));
        arbre.setDiametreCouronneNordSud(cursor.getDouble(30));
        arbre.setDiametreCouronneEstOuest(cursor.getDouble(31));
        arbre.setObservation(cursor.getString(32));
        arbre.setLongitude(cursor.getDouble(33));
        arbre.setLatitude(cursor.getDouble(34));
        arbre.setVisiteFloraison(cursor.getInt(35));
        arbre.setVisiteFructification(cursor.getInt(36));
        arbre.setIdProducteur(cursor.getLong(37));
        arbre.setCodeProducteur(cursor.getString(38));
        arbre.setIdvisiteFloraison(cursor.getLong(39));
        arbre.setCodeFloraison(cursor.getString(40));
        arbre.setIdvisiteFructification(cursor.getLong(41));
        arbre.setCodeFructification(cursor.getString(42));
        return arbre;
    }

}
