package com.example.ilja.brains;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ilja on 16.05.2016.
 */
public class DaytimeStatisticsRepo extends Repo<DaytimeStatistics> {

    public DaytimeStatisticsRepo(SQLiteDatabase database, String tableName, String[] allColumns){
        super(database,tableName,allColumns);
    }

    @Override
    public DaytimeStatistics cursorToEntity(Cursor cursor) {
        DaytimeStatistics daytimeStatistics = new DaytimeStatistics();
        daytimeStatistics.setId(cursor.getLong(0));
        daytimeStatistics.setOperationTypeId(2);
        daytimeStatistics.setDate(cursor.getString(1));
        daytimeStatistics.setCounter(cursor.getInt(3));
        return null;
    }

    @Override
    public ContentValues entityToContentValues(DaytimeStatistics entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_DAYTIMESTATISTICS_OPERATIONTYPEID,entity.getOperationTypeId());
        contentValues.put(MySQLiteHelper.COLUMN_DAYTIMESTATISTICS_DAYSTAMP,entity.getDate());
        contentValues.put(MySQLiteHelper.COLUMN_DAYTIMESTATISCTICS_COUNTER,entity.getCounter());
        return contentValues;
    }
}
