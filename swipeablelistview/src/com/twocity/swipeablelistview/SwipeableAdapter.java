package com.twocity.swipeablelistview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class SwipeableAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> mList;

	public SwipeableAdapter(Context context, List<String> list) {
		this.mContext = context;
		this.mList = list;
	}
	
	public void remove(Object obj) {
		if (obj == null) {
			return;
		}
		
		mList.remove(obj);
		notifyDataSetChanged();
	}
	
	public void removeSelectedId(int id) {
		mList.remove(id);
		notifyDataSetChanged();
	}
	

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public String getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		v = newView(parent);
		if (convertView == null) {
			v = newView(parent);
		} else {
			// Do a translation check to test for animation. Change this to something more
            // reliable and robust in the future.
            if (convertView.getTranslationX() != 0 || convertView.getTranslationY() != 0) {
                // view was animated, reset
                v = newView(parent);
            } else {
                v = convertView;
            }
		}
		v.setTag(getItem(position));
		return v;
	}

	protected abstract View newView(ViewGroup parent);

	protected abstract void bindView(final int position, View view);

}