package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewRefugeAdapter extends BaseAdapter {

    public ArrayList<ListViewRefugeItem> listViewItemList = new ArrayList<ListViewRefugeItem>();

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_refuge, parent , false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.text_refugeName);
        TextView addressView = (TextView) convertView. findViewById(R.id.text_refugeAddress);
        TextView typeView = (TextView) convertView. findViewById(R.id.text_refugeType);
        TextView distanceView = (TextView) convertView.findViewById(R.id.text_refugeDistance);

        ListViewRefugeItem listViewRefugeItem = listViewItemList.get(position);

        nameTextView.setText(listViewRefugeItem.getName());
        addressView.setText(listViewRefugeItem.getAddress());
        typeView.setText(listViewRefugeItem.getType());
        distanceView.setText(listViewRefugeItem.getDistance());


        return convertView;
    }

    public void addItem(String name, String address, String type, String distance) {
        ListViewRefugeItem item = new ListViewRefugeItem();

        item.setName(name);
        item.setAddress(address);
        item.setType(type);
        item.setDistance(distance);

        listViewItemList.add(item);
    }
}
