package com.bzwx.database.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.bzwx.database.BaseDatabaseDao;

public class RecipesDaoImpl extends BaseDatabaseDao {

	@Override
	public long insert(String table, String nullColumnHack, ContentValues values) {
		// TODO Auto-generated method stub
		return super.insert(table, nullColumnHack, values);
	}

	@Override
	public void delete(String table, String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		super.delete(table, whereClause, whereArgs);
	}

	@Override
	public int update(String table, ContentValues values, String whereClause,
			String[] whereArgs) {
		// TODO Auto-generated method stub
		return super.update(table, values, whereClause, whereArgs);
	}

	@Override
	public Cursor rawQuery(String sql, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return super.rawQuery(sql, selectionArgs);
	}

	@Override
	public Cursor query(boolean distinct, String table, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit) {
		// TODO Auto-generated method stub
		return super.query(distinct, table, columns, selection, selectionArgs,
				groupBy, having, orderBy, limit);
	}

	@Override
	public void execSQL(String sql) {
		// TODO Auto-generated method stub
		super.execSQL(sql);
	}

	@Override
	public void execSQLWithParams(String sql, Object[]... objects) {
		// TODO Auto-generated method stub
		super.execSQLWithParams(sql, objects);
	}

}
