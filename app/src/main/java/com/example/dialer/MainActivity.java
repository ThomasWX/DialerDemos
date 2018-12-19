package com.example.dialer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dialer.parser.Contact;
import com.example.dialer.parser.ContactManager;
import com.example.dialer.parser.JsonData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactManager manager = new ContactManager();
        List<Contact> list = manager.parseJsonStr(JsonData.jsonString);
        for (Contact contact :
                list) {
            Log.d("Wangb", "Header:  " + manager.getHeaderString(contact));
            Log.d("Wangb", "Body:  " + manager.getBody(contact));
        }

    }
}
