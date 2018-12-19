package com.example.dialer.parser;

import java.util.List;

public class Contact {

    private long rawContactId;
    private int version;
    private String name;
    private List<Number> numbers;

    public static class Number {
        private String number;
        private int phonetype;
        private String custom;

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getPhonetype() {
            return phonetype;
        }

        public void setPhonetype(int phonetype) {
            this.phonetype = phonetype;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }
    }

    public long getRawContactId() {
        return rawContactId;
    }

    public void setRawContactId(long rawContactId) {
        this.rawContactId = rawContactId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }
}
