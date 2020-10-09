package com.elcio.recyclerview7.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.elcio.recyclerview7.R;
import com.elcio.recyclerview7.adapter.Adapter;
import com.elcio.recyclerview7.model.ListPerson;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fAB;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fAB = findViewById(R.id.floatingActionButton);

        fAB.setOnClickListener(fABListner());

        setRecyclerView();
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        buildAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.HORIZONTAL));
        recyclerView.setAdapter(adapter);
    }

    private void buildAdapter() {
         adapter = new Adapter(new ListPerson().getPersonList());
    }

    private View.OnClickListener fABListner() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
            }
        };
    }
}
