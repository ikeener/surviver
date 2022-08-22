package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class RefugeActivity extends AppCompatActivity {

    private ListView listR;
    private ListViewRefugeAdapter listRAdapter;
    String cs;
    boolean isbuttonclick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuge);

        Button currentButton = (Button) findViewById(R.id.refugeCurrentLocation);
        listR = (ListView) findViewById(R.id.List_Refuge);
        listRAdapter = new ListViewRefugeAdapter();
        listR.setAdapter(listRAdapter);


        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isbuttonclick==true)
                    return;

                dataSetting();
            }
        });

       listR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               ListViewRefugeItem ClickedItem = listRAdapter.listViewItemList.get(position);
               cs = ClickedItem.getName();

               Intent intent = new Intent(RefugeActivity.this, RefugeMap.class);
               intent.putExtra("rname",cs);

               startActivity(intent);
           }
       });

    }

    private void dataSetting() {

        listRAdapter.addItem("가좌초등학교", "경남 진주시 가좌동 564" , "지진실내구호소, 지진옥외대피소","616m");
        listRAdapter.addItem("정촌초등학교", "경남 진주시 가좌동 동부로 11" ,"지진옥외대피소", "1.09km");
        listRAdapter.addItem("개양중학교", "경남 진주시 가좌동 669" , "지진실내구호소, 지진옥외대피소", "1.72km");
        listRAdapter.addItem("진주무지개초등학교","경남 진주시 문산읍 영천강로 119번길 37" ,"지진실내구호소, 지진옥외대피소","4.47km");
        listRAdapter.addItem("진주기계공업고등학교","경남 진주시 상대동 공단로 43번길 25" ,"지진실내구호소, 지진옥외대피소","4.56km");

        listRAdapter.notifyDataSetChanged();
        isbuttonclick = true;

    }

}