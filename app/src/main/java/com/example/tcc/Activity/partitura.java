package com.example.tcc.Activity;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.tcc.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;

public class partitura extends AppCompatActivity {
    int defaltColor;
    SignatureView signatureView;
    ImageButton imgEraser , imgColor,imgSaver;
    SeekBar seekBar;
    TextView txtPaintSize;

    private static String fileName;
    File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/myPaintings");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partitura);
        signatureView = findViewById(R.id.signature_view);
        seekBar = findViewById(R.id.penSize);
        txtPaintSize = findViewById(R.id.txtPenSize);
        imgColor = findViewById(R.id.btnColor);
        imgEraser = findViewById(R.id.btnEraser);
        imgSaver = findViewById(R.id.btnSave);

        askPermission();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss" , Locale.getDefault());
        String date = format.format(new Date());
        fileName = path + "/" + date + ".png";
        if(!path.exists()){

            path.mkdir();

        }

        defaltColor = ContextCompat.getColor(partitura.this, R.color.black);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtPaintSize.setText(i + "dp");
                signatureView.setPenSize(i);
                seekBar.setMax(50);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
        imgEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });
        imgSaver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveImage();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(partitura.this, "Não foi Salvo!", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void saveImage() throws IOException {

        File file = new File(fileName);

        Bitmap bitmap = signatureView.getSignatureBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        byte[] bitmapData = bos.toByteArray();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bitmapData);
        fos.flush();
        fos.close();
        Toast.makeText(this,"Salvo com Sucesso! ", Toast.LENGTH_SHORT).show();


    }

    private void openColorPicker() {

        AmbilWarnaDialog ambilWarnaDialog =  new AmbilWarnaDialog(this, defaltColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                defaltColor = color;
                signatureView.setPenColor(color);
            }

        });
        ambilWarnaDialog.show();




    }


    private void askPermission(){

        Dexter.withContext(this).withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(partitura.this , "Iniciado!" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }


}