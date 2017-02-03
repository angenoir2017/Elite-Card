package com.codeeaters.elitecard.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.codeeaters.elitecard.database.entities.PhotoFructification;

import java.util.ArrayList;

/**
 * Created by leinad on 2/3/17 10:22 PM.
 */

public class PhotoFructificationDAO extends DAO implements IDAO<PhotoFructification> {

    private static final String TAG = "Photo-Fructifi*-DAO-Log";

    public PhotoFructificationDAO(Context context) {
        super(context);
    }

    @Override
    public PhotoFructification add(PhotoFructification entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PhotoFructification.PHOTO_COLUMN, entity.getPhotoBuffer());
        contentValues.put(PhotoFructification.ID_FRUCTIFICATION_COLUMN, entity.getIdvisiteFructification());
        contentValues.put(PhotoFructification.CODE_FRUCTIFICATION_COLUMN, entity.getCodeFructification());
        long result = db.insert(PhotoFructification.TABLE, null, contentValues);
        entity.setIdPhoto(result);
        return entity;
    }

    @Override
    public ArrayList<PhotoFructification> addMany(ArrayList<PhotoFructification> entities) {
        ArrayList<PhotoFructification> photoFructifications = new ArrayList<>();
        for (PhotoFructification photoFructification :
                entities) {
            photoFructification = add(photoFructification);
            photoFructifications.add(photoFructification);
        }
        return photoFructifications;
    }

    @Override
    public boolean updateOne(PhotoFructification entity) {
        return false;
    }

    @Override
    public boolean updateMany(ArrayList<PhotoFructification> entities) {
        return false;
    }

    @Override
    public boolean remove(PhotoFructification entity) {
        return false;
    }

    @Override
    public boolean removeMany(ArrayList<PhotoFructification> entities) {
        return false;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public PhotoFructification fetchOne(int id) {
        PhotoFructification photoFructification = null;

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PhotoFructification.TABLE);
        queryBuilder.appendWhere(PhotoFructification.TABLE + "." + PhotoFructification.ID_PHOTO_FRUCTIFICATION_COLUMN + "=" + id);

        Log.d(TAG, queryBuilder.buildQuery(PhotoFructification.COLUMNS, null, null, null, null, null));

        Cursor cursor = queryBuilder.query(db, PhotoFructification.COLUMNS, null, null, null, null, null);
        if (cursor.moveToNext()) {
            photoFructification = new PhotoFructification();
            photoFructification = appendDataToPhoto(photoFructification, cursor);
        }
        return photoFructification;
    }

    @Override
    public ArrayList<PhotoFructification> fetchAll() {
        return null;
    }

    private PhotoFructification appendDataToPhoto(PhotoFructification photoFructification, Cursor cursor) {
        photoFructification.setIdPhoto(cursor.getLong(0));
        photoFructification.setPhoto(cursor.getBlob(1));
        photoFructification.setIdvisiteFructification(cursor.getLong(2));
        photoFructification.setCodeFructification(cursor.getString(3));
        return photoFructification;
    }
}
