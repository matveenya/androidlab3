package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommentActivity extends AppCompatActivity {

    public EditText comment;
    public Button save;
    public Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        this.comment = (EditText) this.findViewById(R.id.editTextComment);
        this.save = (Button) this.findViewById(R.id.saveComment);
        this.cancel = (Button) this.findViewById(R.id.cancelComment);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("keyType", FieldType.FIELD_COMMENT);
                intent.putExtra("keyString", comment.getText().toString());
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