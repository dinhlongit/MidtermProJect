package com.englishit.midtermproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView tvNumberA;
    TextView tvNumberB;
    TextView tvKetQua;
    Button btnCong;
    Button btnChia;
    Button  btnSendResult;
    int kq = 0;
    int numA=0;
    int numB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNumberA = (TextView) findViewById(R.id.tvNumberA);
        tvNumberB = (TextView) findViewById(R.id.tvNumberB);
        tvKetQua = (TextView) findViewById(R.id.tvKetQua);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnChia = (Button) findViewById(R.id.btnChia);

        btnSendResult = (Button) findViewById(R.id.btnSendResult);
        Intent intent = getIntent();
        numA = intent.getIntExtra("numberA",0);
        numB = intent.getIntExtra("numberB",0);
        tvNumberA.setText(String.valueOf(numA));
        tvNumberB.setText(String.valueOf(numB));

        btnCong.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnSendResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnCong){
            kq = numA + numB;
            tvKetQua.setText(numA + ""+  "+" + numB + "" + " = " + kq);
        }
        if (v == btnChia){
            kq  = numA % numB;
            tvKetQua.setText(numA + ""+  "%" + numB + "" + " = " + kq);
        }


        String s = tvKetQua.getText().toString();
        if (v == btnSendResult){
            Intent intent1 = new Intent();
            intent1.putExtra("ketQua",s);
            setResult(RESULT_OK,intent1);
            finish();

        }

    }
}
