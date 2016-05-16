package com.example.ilja.brains;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ilja on 16.05.2016.
 */
public class OperationRepo extends Repo<Operation> {

    public OperationRepo(SQLiteDatabase database, String tableName, String[] allColumns){
        super(database, tableName, allColumns);
    }

    @Override
    public Operation cursorToEntity(Cursor cursor) {
        Operation operation = new Operation();
        operation.setId(cursor.getLong(0));
        operation.setOperationTypeId(cursor.getLong(1));
        operation.setNumber1(cursor.getDouble(2));
        operation.setNumber2(cursor.getDouble(3));
        operation.setResult(cursor.getDouble(4));

        return operation;
    }

    @Override
    public ContentValues entityToContentValues(Operation entity) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_NUMBER1, entity.getNumber1());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_NUMBER2, entity.getNumber2());
        contentValues.put(MySQLiteHelper.COLUMN_OPERATION_RESULT, entity.getResult());

        return null;
    }


}
