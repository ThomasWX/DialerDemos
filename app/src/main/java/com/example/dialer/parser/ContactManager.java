package com.example.dialer.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ContactManager {
    public List<Contact> parseJsonStr(String jsonStr) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Contact.class, new ContactTypeAdapter()).create();
//        Contact contact = gson.fromJson(jsonStr, Contact.class);
        Type type = new TypeToken<List<Contact>>() {}.getType();
        List<Contact> list = gson.fromJson(jsonStr,type);
        return list;
    }

    public String getHeaderString(Contact contact) {
        return contact.getRawContactId() + " / " + contact.getVersion() + " / " + contact.getName();
    }

    public String getBody(Contact contact) {
        return contact.getNumbers().toString();
    }
}
