package com.kodluyoruz.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class SharedPreferenceActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox chkSaveUsername;
    private EditText edtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        initView();
    }


    private void initView() {
        edtUsername = (EditText) findViewById(R.id.activity_shared_preference_edtUsername);
        chkSaveUsername = (CheckBox) findViewById(R.id.activity_shared_preference_chkSaveUsername);

        initEvent();
    }

    private void initEvent() {
        chkSaveUsername.setOnCheckedChangeListener(this);
        edtUsername.setText(getUsername());

    }

    private void saveOrDeleteUsername(boolean isSave) {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (isSave) {
            editor.putString("Username", edtUsername.getText().toString());
        } else {
            editor.putString("Username", "");
        }
        editor.apply();
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPreference", MODE_PRIVATE);
        return sharedPreferences.getString("Username", "Username is empty");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        saveOrDeleteUsername(b);
    }
}
