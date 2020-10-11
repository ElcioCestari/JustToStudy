package com.elcio.recyclerview7.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elcio.recyclerview7.R;
import com.elcio.recyclerview7.model.Person;
import com.elcio.recyclerview7.model.dao.PersonDAO;
import com.google.android.material.textfield.TextInputEditText;

public class EditActivity extends AppCompatActivity {

    private TextInputEditText editName;
    private Button btnSave;
    private Boolean updateOrSavePerson;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editName = findViewById(R.id.inputTextName);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(myBtnListner());

    }

    @Override
    protected void onResume() {
        super.onResume();

        updateOrSavePerson = loadBundle();
    }

    private Boolean loadBundle() {
        this.person = (Person) getIntent().getSerializableExtra(getString(R.string.person_label));
        if(person != null ){
            setEditName();
            return true;
        }
        return false;
    }

    private void updateAnExistentPerson() {
        PersonDAO personDAO = new PersonDAO(getApplicationContext());
        this.person.setName(getPerson().getName().toString());
        personDAO.update(this.person);
    }

    private void insertNewPerson() {
        PersonDAO personDAO = new PersonDAO(getApplicationContext());
        Person person = getPerson();

        personDAO.insert(person);
    }

    private Person getPerson() {
        String name = editName.getText().toString();
        Integer id = 0;

        return new Person(name,id);
    }

    private void setEditName() {
        Person person = (Person) getIntent().getSerializableExtra(getString(R.string.person_label) );
        this.editName.setText(person.getName().toString());
    }

    private View.OnClickListener myBtnListner() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (updateOrSavePerson) {
                    updateAnExistentPerson();
                } else {
                    insertNewPerson();
                }
                finish();
            }
        };
    }

    private void myCustonToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
