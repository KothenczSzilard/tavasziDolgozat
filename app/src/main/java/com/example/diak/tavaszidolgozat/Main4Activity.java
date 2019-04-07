package com.example.diak.tavaszidolgozat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Main4Activity extends AppCompatActivity {

    private TextView Text_view_qr;
    private Button Button_generate, Button_back2;
    private ImageView Image_view_qr;
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        init();



        Button_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(ip, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    Image_view_qr.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });

        Button_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vissza2 = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(vissza2);
                finish();
            }
        });

    }


    public void init()
    {
        Text_view_qr = (TextView) findViewById(R.id.Text_view_qr);
        Button_generate = (Button) findViewById(R.id.Button_generate);
        Button_back2 = (Button) findViewById(R.id.Button_back2);
        Image_view_qr = (ImageView) findViewById(R.id.Image_View_qr);
    }
}
