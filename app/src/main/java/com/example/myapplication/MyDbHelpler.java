package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SuJinde on 2019/5/28.
 */
public class MyDbHelpler extends SQLiteOpenHelper {
	
	public static final String DB_NAME = "JS.DB";
	public static final int DB_VERSION = 2;
	public static final String GOOD_TABLE_NAME = "FanShi";
	private static final StringBuilder mBUILDER = new StringBuilder();
	
	static {
		mBUILDER.append("CREATE TABLE IF NOT EXISTS ");
		mBUILDER.append(GOOD_TABLE_NAME);
		mBUILDER.append("(_id INTEGER PRIMARY KEY AUTOINCREMENT,");
		mBUILDER.append("name TEXT,");
		mBUILDER.append("face TEXT)");
	}
	
	public static final String CREATE_TABLE = mBUILDER.toString().trim();
	
	public MyDbHelpler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	public MyDbHelpler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + GOOD_TABLE_NAME);
		onCreate(db);
	}
}
