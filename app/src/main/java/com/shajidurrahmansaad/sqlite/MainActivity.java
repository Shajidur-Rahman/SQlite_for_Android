package com.shajidurrahmansaad.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.shajidurrahmansaad.sqlite.Model.Contact;
import com.shajidurrahmansaad.sqlite.data.MyDbHandler;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String log = "dbShajidur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHandler db = new MyDbHandler(MainActivity.this);

        // creating a contact
        Contact shajidur = new Contact();
        shajidur.setName("Shajidur Rahman");
        shajidur.setPhoneNumber("0909090");

        // creating a contact
        Contact muhib = new Contact();
        muhib.setName("Muhib");
        muhib.setPhoneNumber("23232342");

//        db.addContact(shajidur);
//        db.addContact(muhib);

        Log.d("dbShajidur", "onCreate: Successfully added");

        muhib.setId(23);
        muhib.setName("Muhtasim Muhib");
        muhib.setPhoneNumber("903493");
        int affectedRows = db.updateContent(muhib);

        Log.d(log, "onCreate: Number of affected rows are " + affectedRows);

        // get all contacts
        List<Contact> allContacts = db.getAllContacts();

        Log.d("dbShajidur", "onCreate: Yes");

        for (Contact contact: allContacts){
            Log.d("dbShajidur", "\n" + "Id "+ contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n" +
                    "Phone number: " + contact.getPhoneNumber() + "\n");
        }


    }
}