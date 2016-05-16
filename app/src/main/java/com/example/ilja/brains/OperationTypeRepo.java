package com.example.ilja.brains;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ilja on 16.05.2016.
 */
public class OperationTypeRepo extends Repo<OperationType> {

    public OperationTypeRepo(SQLiteDatabase datebase, String tableName, String[] allColumns){
       super(datebase,tableName,allColumns);
    }

    @Override
    public OperationType cursorToEntity(Cursor cursor) {
        OperationType operationType = new OperationType();
        operationType.setId(cursor.getLong(0));
        operationType.setName(cursor.getString(1));

        return operationType;
    }

    @Override
    public ContentValues entityToContentValues(OperationType entity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.COLUMN_OPERATIONTYPES_NAME, entity.getName());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATIONTYPES_COUNTER,entity.getCounter());
        return contentValues;
    }
}
