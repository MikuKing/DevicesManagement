package com.csei.database.entity.service.imple;

import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.csei.database.DBOptions;
import com.csei.database.entity.service.StoreService;

public class StoreServiceImple implements StoreService{
	
	private DBOptions dbOptions;
	private SQLiteDatabase db;

	public StoreServiceImple(Context context) {
		dbOptions = DBOptions.getInstance(context);
		db = dbOptions.getWritableDatabase();
	}

	@Override
	public void addStore(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		//开启事务
				db.beginTransaction();
				db.execSQL(
						"insert into store(id,name,address,telephone) values(?,?,?,?)",
						new Object[] { map.get("id"), map.get("name"),
								map.get("address"), map.get("telephone")});
				//事务成功
				db.setTransactionSuccessful();
				//关闭事务
				db.endTransaction();
	}

	@Override
	public int findIdByName(String name) {
		// TODO Auto-generated method stub
		Cursor cursor = db.rawQuery("select * from store where name=?",  new String[]{name});
		while(cursor.moveToNext()){
			return Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
		}
		return 0;
	}

	@Override
	public String findNameById(int id) {
		// TODO Auto-generated method stub
		Cursor cursor = db.rawQuery("select * from store where id=?",  new String[]{id+""});
		while(cursor.moveToNext()){
			return cursor.getString(cursor.getColumnIndex("id"));
		}
		return null;
	}

}
