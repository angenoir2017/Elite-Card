package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.Arbre;

import java.util.ArrayList;


/**
 * Created by leinad on 1/7/17.
 */

public class ArbreDao extends Dao implements IDao<Arbre> {

    private static final String TAG = "Arbre-Dao-Log";

    public ArbreDao(Context context) {
        super(context);
    }

    @Override
    public Arbre add(Arbre entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Arbre.CODE_ARBRE_COLUMN, entity.getCodeArbre());
        contentValues.put(Arbre.AGE_ARBRE_COLUMN, entity.getAge());
        contentValues.put(Arbre.REGION_COLUMN, entity.getRegion());
        contentValues.put(Arbre.PREFECTURE_COLUMN, entity.getPrefecture());
        contentValues.put(Arbre.CANTON_COLUMN, entity.getCanton());
        contentValues.put(Arbre.VILLAGE_COLUMN, entity.getVillage());
        contentValues.put(Arbre.ORIGINE_COLUMN, entity.getOrigineSemence());
        contentValues.put(Arbre.CHOIX_COLUMN, entity.getChoixMarquage());
        contentValues.put(Arbre.H_COLUMN, entity.getHauteur());
        contentValues.put(Arbre.RN_COLUMN, entity.getRayonNord());
        contentValues.put(Arbre.RS_COLUMN, entity.getRayonSud());
        contentValues.put(Arbre.RE_COLUMN, entity.getRayonEst());
        contentValues.put(Arbre.RO_COLUMN, entity.getRayonOuest());
        contentValues.put(Arbre.CT_COLUMN, entity.getCouronneTaille());
        contentValues.put(Arbre.CE_COLUMN, entity.getCouronneEtalee());
        contentValues.put(Arbre.CC_COLUMN, entity.getCouronneCompacte());
        contentValues.put(Arbre.AR_COLUMN, entity.getArbreRatatine());
        contentValues.put(Arbre.EP_COLUMN, entity.getEcratemementPied());
        contentValues.put(Arbre.DCNS_COLUMN, entity.getDiametreCouronneNordSud());
        contentValues.put(Arbre.DCEO_COLUMN, entity.getDiametreCouronneEstOuest());
        contentValues.put(Arbre.OBS_COLUMN, entity.getObservation());
        contentValues.put(Arbre.LON_COLUMN, entity.getLongitude());
        contentValues.put(Arbre.LAT_COLUMN, entity.getLatitude());
        contentValues.put(Arbre.ID_PRODUCTEUR_COLUMN, entity.getIdProducteur());
        contentValues.put(Arbre.CODE_PRODUCTEUR_COLUMN, entity.getCodeProducteur());
        long result = db.insert(Arbre.TABLE, null, contentValues);
        entity.setIdArbre(result);
        return entity;
    }

    @Override
    public boolean addMany(ArrayList<Arbre> entities) {
        for (Arbre arbre : entities){
            add(arbre);
        }
        return true;
    }

    @Override
    public boolean updateOne(Arbre entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<Arbre> entities) {
        return false;
    }

    @Override
    public boolean remove(Arbre entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<Arbre> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public Arbre fetchOne(int id) {
        Arbre arbre = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Arbre.TABLE);
        queryBuilder.appendWhere(Arbre.TABLE + "." + Arbre.ID_ARBRE_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(Arbre.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, Arbre.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            arbre = new Arbre();
            arbre = appendDataToArbre(arbre, cursor);
        }
        return arbre;
    }

    @Override
    public ArrayList<Arbre> fetchAll() {
        Arbre arbre;
        ArrayList<Arbre> arbres = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Arbre.TABLE);

        Log.d(TAG, queryBuilder.buildQuery(Arbre.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, Arbre.COLUMNS, null, null, null, null, null);
        while (cursor.moveToNext()) {
            arbre = new Arbre();
            arbre = appendDataToArbre(arbre, cursor);
            arbres.add(arbre);
        }
        return arbres;
    }

    public ArrayList<Arbre> fetchAllByProducteur(int idProducteur) {
        Arbre arbre;
        ArrayList<Arbre> arbres = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(Arbre.TABLE);
        queryBuilder.appendWhere(Arbre.ID_PRODUCTEUR_COLUMN +"="+idProducteur);

        Log.d(TAG, queryBuilder.buildQuery(Arbre.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, Arbre.COLUMNS, null, null, null, null, null);
        arbres = new ArrayList<>();
        while (cursor.moveToNext()) {
            arbre = new Arbre();
            arbre = appendDataToArbre(arbre, cursor);
            arbres.add(arbre);
        }
        return arbres;
    }

    private Arbre appendDataToArbre(Arbre arbre, Cursor cursor){
        arbre.setIdArbre(cursor.getLong(0));
        arbre.setCodeArbre(cursor.getString(1));
        arbre.setAge(cursor.getInt(2));
        arbre.setRegion(cursor.getString(3));
        arbre.setPrefecture(cursor.getString(4));
        arbre.setCanton(cursor.getString(5));
        arbre.setVillage(cursor.getString(6));
        arbre.setOrigineSemence(cursor.getString(7));
        arbre.setChoixMarquage(cursor.getInt(8));
        arbre.setHauteur(cursor.getDouble(9));
        arbre.setRayonNord(cursor.getDouble(10));
        arbre.setRayonSud(cursor.getDouble(11));
        arbre.setRayonEst(cursor.getDouble(12));
        arbre.setRayonOuest(cursor.getDouble(13));
        arbre.setCouronneTaille(cursor.getInt(14));
        arbre.setCouronneEtalee(cursor.getString(15));
        arbre.setCouronneCompacte(cursor.getString(16));
        arbre.setArbreRatatine(cursor.getString(17));
        arbre.setEcratemementPied(cursor.getDouble(18));
        arbre.setDiametreCouronneNordSud(cursor.getDouble(19));
        arbre.setDiametreCouronneEstOuest(cursor.getDouble(20));
        arbre.setObservation(cursor.getString(21));
        arbre.setLongitude(cursor.getDouble(22));
        arbre.setLatitude(cursor.getDouble(23));
        arbre.setIdProducteur(cursor.getLong(24));
        arbre.setCodeProducteur(cursor.getString(25));
        return arbre;
    }
}
