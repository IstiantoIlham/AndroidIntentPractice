package com.example.androidintentpractice;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PindahDataActivity extends AppCompatActivity {

    private TextView tv_nama;
    private TextView tv_email;
    private TextView tv_umur;
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pindah_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_nama = findViewById(R.id.tv_nama);
        tv_email = findViewById(R.id.tv_email);
        tv_umur = findViewById(R.id.tv_umur);
        tv_status = findViewById(R.id.tv_status);

        getDataIntent();
    }

    private void getDataIntent() {
        if (getIntent() != null) {
            String nama = getIntent().getStringExtra("KEY_NAMA");
            String email = getIntent().getStringExtra("KEY_EMAIL");
            int umur = getIntent().getIntExtra("KEY_UMUR", 0);
            boolean status = getIntent().getBooleanExtra("KEY_STATUS", false);

            String age = (umur) + " Tahun";
            String stats = "Status ";

            tv_nama.setText(nama);
            tv_email.setText(email);
            tv_umur.setText(age);
            tv_status.setText(status ? stats + "Oke" : stats + "Tidak");

        }
    }
}