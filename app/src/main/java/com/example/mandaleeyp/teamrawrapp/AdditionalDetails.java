package com.example.mandaleeyp.teamrawrapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AdditionalDetails extends AppCompatActivity {

    public EditText et_other;
    public CheckBox cb_envelope, cb_smallBox, cb_largeBox, cb_clothing, cb_other;

    // each index refer to one thing, so [envelope, smbox, lgbox, clothing, other]
    public Boolean[] itemBools = {false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_additional_details);
        String tvl_string_json = getIntent().getStringExtra("travel_notice_json");
        Toast.makeText(getBaseContext(), tvl_string_json, Toast.LENGTH_SHORT).show();
        // JSONObject tvl = getIntent().getStringExtra("travel_notice");

        // get the items in the XML
        et_other = (EditText) findViewById(R.id.et_other);
        cb_envelope = (CheckBox) findViewById(R.id.cb_envelope);
        cb_smallBox = (CheckBox) findViewById(R.id.cb_smallBox);
        cb_largeBox = (CheckBox) findViewById(R.id.cb_largeBox);
        cb_clothing = (CheckBox) findViewById(R.id.cb_clothing);
        cb_other = (CheckBox) findViewById(R.id.cb_other);

        // when user touches outside, we don't want to quit the dialog
        this.setFinishOnTouchOutside(false);
    }

    public void onCheckboxClicked(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.cb_envelope: {
                    itemBools[0] = checked;
                break;
            }
            case R.id.cb_smallBox: {
                    itemBools[1] = checked;
                break;
            }
            case R.id.cb_largeBox: {
                    itemBools[2] = checked;
                break;
            }
            case R.id.cb_clothing: {
                    itemBools[3] = checked;
                break;
            }
            case R.id.cb_other: {
                if (checked) {
                    et_other.setVisibility(View.VISIBLE);
                } else {
                    // make it invisible and clear the text in it
                    et_other.setVisibility(View.INVISIBLE);
                    et_other.setText("");
                }
                break;
            }
            default: {
                break;
            }
        }
    }
}
