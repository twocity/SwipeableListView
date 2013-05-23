package com.twocity.swipeablelistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class SwipeableAdapter extends BaseAdapter {

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
		bindView(position, v);
		return v;
	}

	protected abstract View newView(ViewGroup parent);

	protected abstract void bindView(final int position, View view);

}