package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.VisiteFructification;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 5:34 PM.
 */

public class VisiteFructificationDAO extends DAO implements IDAO<VisiteFructification> {

    private static final String TAG = "Fructific*-DAO-Log";

    public VisiteFructificationDAO(Context context) {
        super(context);
    }

    @Override
    public VisiteFructification add(VisiteFructification entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(VisiteFructification.CODE_FRUCTIFICATION_COLUMN, entity.getCodeFructification());
        contentValues.put(VisiteFructification.DENSITE_COLUMN, entity.getDensite());
        contentValues.put(VisiteFructification.FRUCTIFICATION_HOMOGENE_COLUMN, entity.getFructificationHomogene());
        contentValues.put(VisiteFructification.MATURITE_RAPIDE_HOMOGENE_COLUMN, entity.getMaturiteRapideHomogene());
        contentValues.put(VisiteFructification.FRUIT_MELANGE_FLEUR_COLUMN, entity.getFruitMelangeFleurs());
        contentValues.put(VisiteFructification.OBS_COLUMN, entity.getObs());
        contentValues.put(VisiteFructification.ID_ARBRE_COLUMN, entity.getIdArbre());
        contentValues.put(VisiteFructification.CODE_ARBRE_COLUMN, entity.getCodeArbre());
        long result = db.insert(VisiteFructification.TABLE, null, contentValues);
        entity.setIdvisiteFructification(result);
        return entity;
    }

    @Override
    public ArrayList<VisiteFructification> addMany(ArrayList<VisiteFructification> entities) {
        ArrayList<VisiteFructification> visiteFructifications = new ArrayList<>();
        for (VisiteFructification visiteFructification :
                entities) {
            visiteFructification = add(visiteFructification);
            visiteFructifications.add(visiteFructification);
        }
        return visiteFructifications;
    }

    @Override
    public boolean updateOne(VisiteFructification entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<VisiteFructification> entities) {
        return false;
    }

    @Override
    public boolean remove(VisiteFructification entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<VisiteFructification> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public VisiteFructification fetchOne(int id) {
        VisiteFructification visiteFructification = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(VisiteFructification.TABLE);
        queryBuilder.appendWhere(VisiteFructification.TABLE + "." + VisiteFructification.ID_FRUCTIFICATION_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(VisiteFructification.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, VisiteFructification.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            visiteFructification = new VisiteFructification();
            visiteFructification = appendDataToVistite(visiteFructification, cursor);
        }
        return visiteFructification;
    }

    @Override
    public ArrayList<VisiteFructification> fetchAll() {
        return null;
    }

    private VisiteFructification appendDataToVistite(VisiteFructification visiteFructification, Cursor cursor){
        visiteFructification.setIdvisiteFructification(cursor.getLong(0));
        visiteFructification.setCodeFructification(cursor.getString(1));
        visiteFructification.setDensite(cursor.getString(2));
        visiteFructification.setFructificationHomogene(cursor.getInt(3));
        visiteFructification.setMaturiteRapideHomogene(cursor.getInt(4));
        visiteFructification.setFruitMelangeFleurs(cursor.getInt(5));
        visiteFructification.setObs(cursor.getString(6));
        visiteFructification.setIdArbre(cursor.getInt(7));
        visiteFructification.setCodeArbre(cursor.getString(8));
        return visiteFructification;
    }
}
