package com.slack.joiple.a2018_busan_ict_hackerton_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NfcTagging extends AppCompatActivity {
    private Intent cardService;
    private Button cancelBtn,qrModeBtn;
    Intent o,g;
    @Override
    protected void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        this.setContentView(R.layout.activity_nfc_tagging);
        g=getIntent();
        cancelBtn=findViewById(R.id.cancelBtn);
        qrModeBtn=findViewById(R.id.qrModeBtn);
        cardService=new Intent(this,NfcService.class);
        startService(cardService);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        qrModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                o=new Intent(NfcTagging.this,QrReader.class);
                o.setAction(g.getAction());
                startActivity(o);
                NfcTagging.this.finish();
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(cardService);
    }
}
