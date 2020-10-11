package com.elcio.recyclerview7.model;

import android.content.Context;

import com.elcio.recyclerview7.model.dao.PersonDAO;

import java.util.ArrayList;
import java.util.List;

public class ListPerson {
    List<Person> personList;
    private Context context;

    public ListPerson(Context context) {
        this.context = context;
        this.personList = new ArrayList<>();

    }

    private void addPersonToDataBase() {
        PersonDAO personDAO =new PersonDAO(context);

        addPersonToList();

        for(int i = 0; i < personList.size(); i++){
            personDAO.insert(personList.get(i));
        }

    }

    private void addPersonToList() {
        Person p;

        p = new Person("elcio", 1);
        this.personList.add(p);
        p = new Person("maria", 2);
        this.personList.add(p);
        p = new Person("pedro", 3);
        this.personList.add(p);
        p = new Person("gabigol", 4);
        this.personList.add(p);
        p = new Person("bruno henrique", 5);
        this.personList.add(p);
        p = new Person("everto ribeiro", 6);
        this.personList.add(p);
        p = new Person("arrascaeta", 7);
        this.personList.add(p);
        p = new Person("elcio", 8);
        this.personList.add(p);
        p = new Person("elcio", 9);
        this.personList.add(p);
        p = new Person("elcio", 10);
        this.personList.add(p);
        p = new Person("elcio", 11);
        this.personList.add(p);
        p = new Person("elcio", 12);
        this.personList.add(p);
        p = new Person("elcio", 13);
        this.personList.add(p);
        p = new Person("elcio", 14);
        this.personList.add(p);
        p = new Person("elcio", 15);
        this.personList.add(p);
        p = new Person("elcio", 16);
        this.personList.add(p);

    }

    public List<Person> getPersonList() {
        if (this.personList.size() <= 0) this.loadPersonList();
        return this.personList;
    }

    private void loadPersonList() {
        this.setPersonList(new PersonDAO(context).selectAll());
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
