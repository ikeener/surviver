package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PopupNotificationActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton sc;
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private CheckBox c5;
    private EditText etL;
    private String SelectedCategory;
    private String SelectedDamage;
    private String InputPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_notification);

        rg = findViewById(R.id.radioGroup_category);
        c1 = (CheckBox) findViewById(R.id.check_BuildingBreak);
        c2 = (CheckBox) findViewById(R.id.check_RoadFailure);
        c3 = (CheckBox) findViewById(R.id.check_Inundation);
        c4 = (CheckBox) findViewById(R.id.check_BuildingCollapse);
        c5 = (CheckBox) findViewById(R.id.check_NoAccess);

        etL = (EditText) findViewById(R.id.et_position);

        Button Okbtn = (Button) findViewById(R.id.okBtn);
        Button Cancelbtn = (Button) findViewById(R.id.cancelBtn);

        final Intent resultIntent = new Intent();

        Okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                SelectedCategory = sc.getText().toString();

                SelectedDamage = "";
                if(c1.isChecked() == true) SelectedDamage += c1.getText().toString() + " ";
                if(c2.isChecked() == true) SelectedDamage += c2.getText().toString() + " ";
                if(c3.isChecked() == true) SelectedDamage += c3.getText().toString() + " ";
                if(c4.isChecked() == true) SelectedDamage += c4.getText().toString() + " ";
                if(c5.isChecked() == true) SelectedDamage += c5.getText().toString() + " ";

                InputPosition = etL.getText().toString();

                resultIntent.putExtra("disaster",SelectedCategory);
                resultIntent.putExtra("damage",SelectedDamage);
                resultIntent.putExtra("location",InputPosition);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

        Cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,resultIntent);
                finish();
            }
        });


    }



}
