package com.example.test;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class HospitalActivity extends AppCompatActivity {

    private ListView listH;
    private ListViewHospitalAdapter listHAdapter;
    String cs;
    boolean isbuttonclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        Button currentButton = (Button) findViewById(R.id.hospitalCurrentLocation);
        listH = (ListView) findViewById(R.id.List_Hospital);
        listHAdapter = new ListViewHospitalAdapter();
        listH.setAdapter(listHAdapter);

        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isbuttonclick==true)
                    return;

                dataSetting();
            }
        });


        listH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewHospitalItem ClickedItem = listHAdapter.listViewItemList.get(position);
                cs = ClickedItem.getName();

                Intent intent = new Intent(HospitalActivity.this, HospitalMap.class);
                intent.putExtra("hname",cs);

                startActivity(intent);
            }
        });

    }

    private void dataSetting() {

        listHAdapter.addItem("진주한일병원","경남 진주시 상평동 164-4", "055-759-7777","3.25km");
        listHAdapter.addItem("경상대학교병원","경남 진주시 칠암동 90", "055-750-8000","3.41km");
        listHAdapter.addItem("진주세란병원","경남 진주시 주약동 진주대로 829", "055-760-7578","3.42km");
        listHAdapter.addItem("진주고려병원","경남 진주시 침암동 485-2", "055-751-2500","3.84km");
        listHAdapter.addItem("진주제일병원","경남 진주시 강남동 진주대로 885", "055-750-7123","4.14km");

        listHAdapter.notifyDataSetChanged();
        isbuttonclick = true;
    }

}
