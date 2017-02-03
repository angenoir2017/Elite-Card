package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.VisiteFloraison;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 5:34 PM.
 */

public class VisiteFloraisonDAO extends DAO implements IDAO<VisiteFloraison> {

    private static final String TAG = "Floraison-DAO-Log";

    public VisiteFloraisonDAO(Context context) {
        super(context);
    }

    @Override
    public VisiteFloraison add(VisiteFloraison entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(VisiteFloraison.ID_FLORAISON_COLUMN, entity.getIdvisiteFloraison());
        contentValues.put(VisiteFloraison.CODE_FLORAISON_COLUMN, entity.getCodeFloraison());
        contentValues.put(VisiteFloraison.DATE_COLUMN, entity.getDateFloraison());
        contentValues.put(VisiteFloraison.ID_ARBRE_COLUMN, entity.getIdArbre());
        contentValues.put(VisiteFloraison.CODE_ARBRE_COLUMN, entity.getCodeArbre());
        long result = db.insert(VisiteFloraison.TABLE, null, contentValues);
        entity.setIdvisiteFloraison(result);
        return entity;
    }

    @Override
    public ArrayList<VisiteFloraison> addMany(ArrayList<VisiteFloraison> entities) {
        ArrayList<VisiteFloraison> visiteFloraisons = new ArrayList<>();
        for (VisiteFloraison visiteFloraison :
                entities) {
            visiteFloraison = add(visiteFloraison);
            visiteFloraisons.add(visiteFloraison);
        }
        return visiteFloraisons;
    }

    @Override
    public boolean updateOne(VisiteFloraison entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<VisiteFloraison> entities) {
        return false;
    }

    @Override
    public boolean remove(VisiteFloraison entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<VisiteFloraison> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public VisiteFloraison fetchOne(int id) {
        VisiteFloraison visiteFloraison = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(VisiteFloraison.TABLE);
        queryBuilder.appendWhere(VisiteFloraison.TABLE + "." + VisiteFloraison.ID_FLORAISON_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(VisiteFloraison.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, VisiteFloraison.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            visiteFloraison = new VisiteFloraison();
            visiteFloraison = appendDataToVistite(visiteFloraison, cursor);
        }
        return visiteFloraison;
    }

    @Override
    public ArrayList<VisiteFloraison> fetchAll() {
        return null;
    }

    private VisiteFloraison appendDataToVistite(VisiteFloraison visiteFloraison, Cursor cursor){
        visiteFloraison.setIdvisiteFloraison(cursor.getLong(0));
        visiteFloraison.setCodeFloraison(cursor.getString(1));
        visiteFloraison.setTauxAbondance(cursor.getString(2));
        visiteFloraison.setDateFloraison(cursor.getString(3));
        visiteFloraison.setIdArbre(cursor.getInt(4));
        visiteFloraison.setCodeArbre(cursor.getString(5));
        return visiteFloraison;
    }
}
