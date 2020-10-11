package com.elcio.recyclerview7.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.elcio.recyclerview7.helper.MyDbHelper;
import com.elcio.recyclerview7.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements BaseDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public PersonDAO(Context context) {
        MyDbHelper db = new MyDbHelper(context);
        this.write = db.getWritableDatabase();
        this.read = db.getReadableDatabase() ;
    }

    @Override
    public boolean insert(Person person) {
        ContentValues values = new ContentValues();
        values.put(MyDbHelper.COLUMN_NAME_NAME, person.getName().toString());
        try {
            write.insertOrThrow(MyDbHelper.TABLE_NAME_PERSON, null, values);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Person person) {
        String table = MyDbHelper.TABLE_NAME_PERSON;
        ContentValues values = new ContentValues();
        values.put(MyDbHelper.COLUMN_NAME_NAME, person.getName().toString());
        String whereClause = "id=?";
        String[] whereArgs = {person.getId().toString()};

        try {
            write.update(table, values, whereClause, whereArgs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }
    @Override
    public Person select(Person person) {
        return null;
    }

    @Override
    public List<Person> selectAll() {

        List<Person> list = new ArrayList<>();
        String name;
        Integer id;
        Person person;

        String sql = "SELECT * FROM " + MyDbHelper.TABLE_NAME_PERSON;
        Cursor  cursor = read.rawQuery(sql, null);

        cursor.moveToFirst();
        while (cursor != null ){

            name = cursor.getString( cursor.getColumnIndex(MyDbHelper.COLUMN_NAME_NAME) );
            id = cursor.getInt( cursor.getColumnIndex(MyDbHelper.COLUMN_NAME_ID) );

            person = new Person(name,id);
            list.add(person);

            if(cursor.isLast()) break;
            cursor.moveToNext();
        }
        return list;
    }
}
