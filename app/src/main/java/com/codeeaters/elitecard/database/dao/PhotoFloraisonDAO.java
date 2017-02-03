package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.PhotoFloraison;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 7:27 PM.
 */

public class PhotoFloraisonDAO extends DAO implements IDAO<PhotoFloraison> {

    private static final String TAG = "Photo-Floraison-DAO-Log";

    public PhotoFloraisonDAO(Context context) {
        super(context);
    }

    @Override
    public PhotoFloraison add(PhotoFloraison entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PhotoFloraison.PHOTO_COLUMN, entity.getPhotoBuffer());
        contentValues.put(PhotoFloraison.ID_FLORAISON_COLUMN, entity.getIdvisiteFloraison());
        contentValues.put(PhotoFloraison.CODE_FLORAISON_COLUMN, entity.getCodeFloraison());
        long result = db.insert(PhotoFloraison.TABLE, null, contentValues);
        entity.setIdPhoto(result);
        return entity;
    }

    @Override
    public ArrayList<PhotoFloraison> addMany(ArrayList<PhotoFloraison> entities) {
        ArrayList<PhotoFloraison> photoFloraisons = new ArrayList<>();
        for (PhotoFloraison photoFloraison :
                entities) {
            photoFloraison = add(photoFloraison);
            photoFloraisons.add(photoFloraison);
        }
        return photoFloraisons;
    }

    @Override
    public boolean updateOne(PhotoFloraison entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<PhotoFloraison> entities) {
        return false;
    }

    @Override
    public boolean remove(PhotoFloraison entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<PhotoFloraison> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public PhotoFloraison fetchOne(int id) {
        PhotoFloraison photoFloraison = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PhotoFloraison.TABLE);
        queryBuilder.appendWhere(PhotoFloraison.TABLE + "." + PhotoFloraison.ID_PHOTO_FLORAISON_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(PhotoFloraison.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, PhotoFloraison.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            photoFloraison = new PhotoFloraison();
            photoFloraison = appendDataToPhoto(photoFloraison, cursor);
        }
        return photoFloraison;
    }

    @Override
    public ArrayList<PhotoFloraison> fetchAll() {
        return null;
    }

    private PhotoFloraison appendDataToPhoto(PhotoFloraison photoFloraison, Cursor cursor) {
        photoFloraison.setIdPhoto(cursor.getLong(0));
        photoFloraison.setPhoto(cursor.getBlob(1));
        photoFloraison.setIdvisiteFloraison(cursor.getLong(2));
        photoFloraison.setCodeFloraison(cursor.getString(3));
        return photoFloraison;
    }
}
