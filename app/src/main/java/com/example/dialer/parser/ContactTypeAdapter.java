package com.example.dialer.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactTypeAdapter extends TypeAdapter<Contact> {
    private static final String RAW_CONTACT_ID_TAG = "raw_contact_id";
    private static final String VERSION_TAG = "version  ";
    private static final String NAME_TAG = "name";
    private static final String NUMBERS_TAG = "numbers";
    private static final String NUMBERS_NUMBER_TAG = "number";
    private static final String NUMBERS_PHONE_TYPE_TAG = "phonetype";
    private static final String NUMBERS_CUSTOM_TAG = "custom";



    @Override
    public void write(JsonWriter jsonWriter, Contact contact) throws IOException {

    }

    @Override
    public Contact read(JsonReader in) throws IOException {
        Contact contact = new Contact();
        
        in.beginObject(); // 流式反序列化开始 Streaming deserialization begins
        String tag;
        while (in.hasNext()) {
            tag = in.nextName();
            if (RAW_CONTACT_ID_TAG.equals(tag)) {
                contact.setRawContactId(in.nextLong());
            } else if (VERSION_TAG.equals(tag)) {
                contact.setVersion(in.nextInt());
            } else if (NAME_TAG.equals(tag)) {
                contact.setName(in.nextString());
            } else if (NUMBERS_TAG.equals(tag)) {
                in.beginArray();
                final List<Contact.Number> numbers = new ArrayList<>();
                Contact.Number numberEntity;
                String numberTag;
                while (in.hasNext()){
                    in.beginObject();
                    numberTag = in.nextName();
                    numberEntity = new Contact.Number();
                    if (NUMBERS_NUMBER_TAG.equals(numberTag)){
                        numberEntity.setNumber(in.nextString());
                    } else if (NUMBERS_PHONE_TYPE_TAG.equals(numberTag)){
                        numberEntity.setPhonetype(in.nextInt());
                    } else if (NUMBERS_CUSTOM_TAG.equals(numberTag)){
                        numberEntity.setCustom(in.nextString());
                    }
                    numbers.add(numberEntity);
                    in.endObject();
                }
                contact.setNumbers(numbers);
                in.endArray();
            }
        }
        return contact;
    }
}
