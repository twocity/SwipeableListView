package com.twocity.swipeablelistviewsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void doClick(View v) {
		if (v.getId() == R.id.button_normal) {
			startActivity(new Intent(this, NormalListActivity.class));
		} else if (v.getId() == R.id.button_indicator) {

		}
	}
}
