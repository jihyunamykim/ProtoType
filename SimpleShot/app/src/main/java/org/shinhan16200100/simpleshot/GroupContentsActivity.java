package org.shinhan16200100.simpleshot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GroupContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_contents);

        Button b = (Button)findViewById(R.id.group1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        ContentsInfoActivity.class);
                startActivity(intent);
            }
        });

        Button c = (Button)findViewById(R.id.plus_group);
        c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MakeGroupActivity.class);
                startActivity(intent);
            }
        });
    }
}
