package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    public EditText surname;
    public EditText name;
    public Button save;
    public Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        this.surname = (EditText) this.findViewById(R.id.editTextSurname);
        this.name = (EditText) this.findViewById(R.id.editTextName);
        this.save = (Button) this.findViewById(R.id.saveName);
        this.cancel = (Button) this.findViewById(R.id.cancelName);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("keyType", FieldType.FIELD_NAME);
                intent.putExtra("keyString", surname.getText().toString()+" "+ name.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setResult(RESULT_CANCELED);
               finish();
            }
        });


    }
}