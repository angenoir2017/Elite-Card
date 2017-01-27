package com.codeeaters.elitecard.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leinad on 1/21/17 10:03 AM.
 */

public class SpinnerAdapter extends ArrayAdapter<String> {

    private Typeface ubuntuCondenced = Typeface.createFromAsset(getContext().getAssets(), "fonts/PoiretOne-Regular.ttf");

    public SpinnerAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setTypeface(ubuntuCondenced);
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        textView.setTypeface(ubuntuCondenced);
        return textView;
    }
}
