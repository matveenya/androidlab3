package com.example.lab4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView name;
    public TextView address;
    public TextView comment;
    public Button editName;
    public Button editAddress;
    public Button editComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (TextView) this.findViewById(R.id.nameMain);
        this.address = (TextView) this.findViewById(R.id.addressMain);
        this.comment = (TextView) this.findViewById(R.id.commentMain);

        this.editName = (Button) this.findViewById(R.id.editName);
        this.editAddress = (Button) this.findViewById(R.id.editAddress);
        this.editComment = (Button) this.findViewById(R.id.editComment);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            FieldType fieldType = (FieldType) data.getSerializableExtra("keyType");
                            String values = (String) data.getSerializableExtra("keyString");
                            switch (fieldType){
                                case FIELD_NAME:
                                    name.setText(values);
                                    break;
                                case FIELD_ADDRESS:
                                    address.setText(values);
                                    break;
                                case FIELD_COMMENT:
                                    comment.setText(values);
                                    break;
                            }
                        }
                    }
                });

        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NameActivity.class);
                someActivityResultLauncher.launch(intent);
            }
        });

        editAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                someActivityResultLauncher.launch(intent);
            }
        });

        editComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                someActivityResultLauncher.launch(intent);
            }
        });
    }

   @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Name", String.valueOf(name.getText()));
        outState.putString("Address", String.valueOf(address.getText()));
        outState.putString("Comment", String.valueOf(comment.getText()));
    }
   @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        name.setText(savedInstanceState.getString("Name"));
        address.setText(savedInstanceState.getString("Address"));
        comment.setText(savedInstanceState.getString("Comment"));
    }

}