package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidTaskStackActivity extends AppCompatActivity {
	public final String TAG = "ZM--"+this.getClass().getSimpleName();
	Intent intent = null;
	@BindView(R.id.tvClassName)
	TextView mTvClassName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_stack);
		ButterKnife.bind(this);
		mTvClassName.setText(this.getClass().getSimpleName());
		print("onCreate");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		print("onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		print("onResume");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		print("onPause");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		print("onStop");
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		print("onRestart");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		print("onDestroy");
	}
	
	public void print(String life) {
		Log.d(TAG, life);
	}
	
	@OnClick({R.id.standard, R.id.singleTop, R.id.singleTask, R.id.singleInstance, R.id.clearTop, R.id.newTask, R.id.launch, R.id.clearTask, R.id.mulTask, R.id.noHistory})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.standard:
				intent = new Intent(this, StandardActivity.class);
				break;
			case R.id.singleTop:
				intent = new Intent(this, SingleTopActivity.class);
				break;
			case R.id.singleTask:
				intent = new Intent(this, SingleTaskActivity.class);
				break;
			case R.id.singleInstance:
				intent = new Intent(this, SingleInstanceActivity.class);
				break;
			case R.id.clearTop:
				addFlag(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				break;
			case R.id.newTask:
				addFlag(Intent.FLAG_ACTIVITY_NEW_TASK);
				break;
			case R.id.mulTask:
				addFlag(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
				break;
			case R.id.clearTask:
				addFlag(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				break;
			case R.id.noHistory:
				addFlag(Intent.FLAG_ACTIVITY_NO_HISTORY);
				break;
			case R.id.launch:
				startActivity(intent);
				break;
		}
	}
	
	private void addFlag(int flagActivityNoHistory) {
		if (null == intent) {
			return;
		}
		intent.addFlags(flagActivityNoHistory);
	}
	
	
	private void query() {
		Cursor cursor = getContentResolver().query(Loneliness.CONTENT_URI, null, null, null, null);
		if (null != cursor) {
			while (cursor.moveToNext()) {
				System.out.println(cursor.getString(1));
			}
		}
	}
	
	private void insert() {
		ContentValues values = new ContentValues();
		values.put(Loneliness.NAME, "琪琪");
		getContentResolver().insert(Loneliness.CONTENT_URI, values);
	}
}
