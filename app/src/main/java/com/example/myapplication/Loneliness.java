package com.example.myapplication;

import android.net.Uri;

/**
 * Created by SuJinde on 2019/5/28.
 */
public class Loneliness {
	public static final String AUTHORITY = "com.example.myapplication.JSProvider";
	public static final String TABLE_NAME = MyDbHelpler.GOOD_TABLE_NAME;
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);
	public static final String NAME = "name";
	public static final String FACE="face";
}
