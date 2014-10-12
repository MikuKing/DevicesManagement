package com.csei.devicesmanagement;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private GridView gridView;
	int[] images = { R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher, R.drawable.ic_launcher,
			R.drawable.ic_launcher };
	String[] functions = { "设备入库", "设备出库", "设备安装", "设备卸载", "设备运输" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView = (GridView) findViewById(R.id.function_choose);
		gridView.setAdapter(getGridAdapter(functions, images));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:

					Intent it1 = new Intent(MainActivity.this,
							StockInActivity.class);
					startActivity(it1);

					break;
				case 1:

					Intent it2 = new Intent(MainActivity.this,
							StockOutActivity.class);
					startActivity(it2);

					break;
				case 2:

					Intent it3 = new Intent(MainActivity.this,
							InstallActivity.class);
					startActivity(it3);

					break;
				case 3:

					Intent it4 = new Intent(MainActivity.this,
							UninstallActivity.class);
					startActivity(it4);

					break;
				case 4:

					Intent it5 = new Intent(MainActivity.this,
							TransportActivity.class);
					startActivity(it5);

					break;
				}
			}
		});
	}

	private ListAdapter getGridAdapter(String[] functions, int[] images) {
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < functions.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemImage", images[i]);
			map.put("itemText", functions[i]);
			data.add(map);
		}
		SimpleAdapter simperAdapter = new SimpleAdapter(this, data,
				R.layout.grid_item_main,
				new String[] { "itemImage", "itemText" }, new int[] {
						R.id.iv_icon, R.id.tv_function }) {
		};
		return simperAdapter;

	}
}
