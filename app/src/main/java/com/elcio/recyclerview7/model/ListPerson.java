package com.elcio.recyclerview7.model;

import java.util.ArrayList;
import java.util.List;

public class ListPerson {
    List<Person> personList;

    public ListPerson() {
        this.personList = new ArrayList<>();
        addPersonToList();
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
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
