package com.englishit.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edNumberA;
    EditText edNumberB;
    Button btnSend;
    ListView listView;

    ArrayList<String> dsKetQua;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1998){
            if (resultCode == RESULT_OK){
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,dsKetQua);
                listView.setAdapter(arrayAdapter);
                String text = data.getStringExtra("ketQua");
                dsKetQua.add(text);
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dsKetQua = new ArrayList<String>();

        edNumberA = (EditText) findViewById(R.id.edNumberA);
        edNumberB = (EditText) findViewById(R.id.edNumberB);
        btnSend = (Button) findViewById(R.id.btnSend);
        listView = (ListView) findViewById(R.id.listView);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (edNumberA.getText().toString().isEmpty() || edNumberB.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this,"Please Enter a Number !!!!!!!!!",Toast.LENGTH_LONG).show();
                    }
                    else {

                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("numberA", Integer.parseInt(edNumberA.getText().toString()));
                        intent.putExtra("numberB", Integer.parseInt(edNumberB.getText().toString()));
                        startActivityForResult(intent,1998);
                    }

            }
        });

    }



}
