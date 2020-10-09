package com.elcio.recyclerview7.model.dao;

import com.elcio.recyclerview7.model.Person;

import java.util.List;

public interface BaseDAO {

    boolean insert(Person person);
    boolean update(Person person);
    boolean delete(Person person);
    Person select(Person person);
    List<Person> selectAll();
}
