package com.twocity.swipeablelistviewsample;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twocity.swipeablelistview.SwipeableAdapter;

public class NormalSwipeableAdapter extends SwipeableAdapter {

	private Context mContext;
	private List<String> mList;

	public NormalSwipeableAdapter(Context context, List<String> list) {
		this.mContext = context;
		this.mList = list;
	}

	public void remove(Object obj) {
		mList.remove(obj);
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	protected View newView(ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.layout_swipe_normal_item, parent,
				false);
		v.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("", "======onClick");
				
			}
		});
		return v;

	}

	@Override
	protected void bindView(int position, View view) {
		String content = mList.get(position);
		TextView text = (TextView) view.findViewById(R.id.text1);
		text.setText(content);
	}

}