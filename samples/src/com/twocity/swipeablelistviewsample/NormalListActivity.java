package com.twocity.swipeablelistviewsample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.twocity.swipeablelistview.SwipeableListView;
import com.twocity.swipeablelistview.SwipeableListView.OnItemSwipeListener;
import com.twocity.swipeablelistview.SwipeableListView.OnSwipeItemClickListener;

public class NormalListActivity extends Activity {
	private SwipeableListView listView;

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_normal);

		setupListView();
	}

	private void setupListView() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 30; i++) {
			list.add("Sample List Item " + i);
		}

		listView = (SwipeableListView) findViewById(R.id.swipe_list);
		listView.setItemsCanFocus(true);
		// enable swipeable
		listView.enableSwipe(true);

		final NormalSwipeableAdapter adapter = new NormalSwipeableAdapter(
				getApplicationContext(), list);
		listView.setAdapter(adapter);
		adapter.setListView(listView);

		listView.setOnItemSwipeListener(new OnItemSwipeListener() {

			@Override
			public void onSwipe(View view) {
				if (view.getTag() instanceof String) {
					Toast.makeText(getApplicationContext(), "swipe",
							Toast.LENGTH_SHORT).show();
					adapter.remove(view.getTag());
				}
			}
		});

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), "item clicked.", Toast.LENGTH_SHORT).show();

			}
		});
		
		listView.setOnSwipeItemClickListener(new OnSwipeItemClickListener() {
			
			@Override
			public void onClick(int position, View view) {
				Toast.makeText(getApplicationContext(), view.getTag().toString(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}