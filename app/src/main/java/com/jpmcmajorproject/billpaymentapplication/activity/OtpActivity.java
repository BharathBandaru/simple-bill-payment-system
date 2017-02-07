package com.jpmcmajorproject.billpaymentapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jpmcmajorproject.billpaymentapplication.R;
import com.jpmcmajorproject.billpaymentapplication.service.HttpService;

/**
 * Created by Bharath on 05/02/17.
 */

public class OtpActivity extends Activity implements View.OnClickListener {
    private EditText inputOtp;
    Button btnVerifyOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_activity);
                inputOtp = (EditText) findViewById(R.id.otp_id);
                btnVerifyOtp = (Button) findViewById(R.id.otp_button);
        btnVerifyOtp.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        verifyOtp();

    }
    private void verifyOtp() {
        String otp = inputOtp.getText().toString().trim();

        if (!otp.isEmpty()) {
            Intent grapprIntent = new Intent(getApplicationContext(), HttpService.class);
            grapprIntent.putExtra("otp", otp);
            startService(grapprIntent);
        } else {
            Toast.makeText(getApplicationContext(), "Please enter the OTP", Toast.LENGTH_SHORT).show();
        }
    }

}
