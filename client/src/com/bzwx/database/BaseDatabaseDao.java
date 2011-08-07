package com.bzwx.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BaseDatabaseDao {

	private DatabaseHelper helper;

	public long insert(String table, String nullColumnHack, ContentValues values) {
		SQLiteDatabase db = helper.getWritableDatabase();
		long _id = db.insert(table, nullColumnHack, values);
		db.close();
		return _id;
	}

	public void delete(String table, String whereClause, String[] whereArgs) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.delete(table, whereClause, whereArgs);
		db.close();
	}

	public int update(String table, ContentValues values, String whereClause,
			String[] whereArgs) {
		SQLiteDatabase db = helper.getWritableDatabase();
		int _id = db.update(table, values, whereClause, whereArgs);
		db.close();
		return _id;
	}

	public Cursor rawQuery(String sql, String[] selectionArgs) {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery(sql, selectionArgs);
		db.close();
		return cursor;
	}

	public Cursor query(boolean distinct, String table, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit) {
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.query(distinct, table, columns, selection,
				selectionArgs, groupBy, having, orderBy, limit);
		db.close();
		return cursor;
	}

	public void execSQL(String sql) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(sql);
		db.close();
	}

	public void execSQLWithParams(String sql, Object[]... objects) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(sql, objects);
		db.close();
	}

}
