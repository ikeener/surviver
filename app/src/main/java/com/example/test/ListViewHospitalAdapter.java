package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewHospitalAdapter extends BaseAdapter {

    public ArrayList<ListViewHospitalItem> listViewItemList = new ArrayList<ListViewHospitalItem>();

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
            convertView = inflater.inflate(R.layout.listview_item_hospital, parent , false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.text_hospitalName);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.text_hospitalAddress);
        TextView phoneNumberTextView = (TextView) convertView.findViewById(R.id.text_hospitalPhoneNumber);
        TextView distanceTextView = (TextView) convertView.findViewById(R.id.text_hospitalDistance);

        ListViewHospitalItem listviewHospitalItem = listViewItemList.get(position);

        nameTextView.setText(listviewHospitalItem.getName());
        addressTextView.setText(listviewHospitalItem.getAddress());
        phoneNumberTextView.setText(listviewHospitalItem.getPhoneNumber());
        distanceTextView.setText(listviewHospitalItem.getDistance());

        return convertView;
    }

    public void addItem(String name, String address, String phoneNumber, String distance) {
        ListViewHospitalItem item = new ListViewHospitalItem();

        item.setName(name);
        item.setAddress(address);
        item.setPhoneNumber(phoneNumber);
        item.setDistance(distance);

        listViewItemList.add(item);
    }
}
