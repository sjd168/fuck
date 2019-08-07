package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by SuJinde on 2019/5/28.
 */
public class JSProvider extends ContentProvider {
	MyDbHelpler mDbHelpler;
	SQLiteDatabase db;
	
	@Override
	public boolean onCreate() {
		mDbHelpler = new MyDbHelpler(getContext());
		db = mDbHelpler.getWritableDatabase();
		return false;
	}
	
	@androidx.annotation.Nullable
	@Override
	public Cursor query(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable String[] projection, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs, @androidx.annotation.Nullable String sortOrder) {
		return db.query(Loneliness.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
	}
	
	@androidx.annotation.Nullable
	@Override
	public String getType(@androidx.annotation.NonNull Uri uri) {
		return null;
	}
	
	@androidx.annotation.Nullable
	@Override
	public Uri insert(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable ContentValues values) {
		db.insert(Loneliness.TABLE_NAME, null, values);
		getContext().getContentResolver().notifyChange(uri, null);
		return uri;
	}
	
	@Override
	public int delete(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs) {
		return 0;
	}
	
	@Override
	public int update(@androidx.annotation.NonNull Uri uri, @androidx.annotation.Nullable ContentValues values, @androidx.annotation.Nullable String selection, @androidx.annotation.Nullable String[] selectionArgs) {
		return 0;
	}
}
