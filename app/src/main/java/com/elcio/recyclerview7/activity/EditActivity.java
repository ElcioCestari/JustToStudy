package com.elcio.recyclerview7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elcio.recyclerview7.R;
import com.elcio.recyclerview7.model.Person;
import com.google.android.material.textfield.TextInputEditText;

public class EditActivity extends AppCompatActivity {

    private TextInputEditText editName;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName = findViewById(R.id.inputTextName);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(myBtnListner());

        loadBundle();
    }

    private void loadBundle() {
        if(getIntent().getSerializableExtra(getString(R.string.person_label)).equals(null) ){
            myCustonToast("vazio");
        }else{
            setEditName();
        }
    }

    private void setEditName() {
        Person person = (Person) getIntent().getSerializableExtra(getString(R.string.person_label) );
        this.editName.setText(person.getName().toString());
    }

    private View.OnClickListener myBtnListner() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCustonToast("salvando...");
            }
        };
    }

    private void myCustonToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
