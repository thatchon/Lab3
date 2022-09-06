package com.example.lab3;

public class Customer {
    private String ID, name;
    private boolean sex;
    private int age;

    public Customer() {
        this("", null, "female", 0);
    }

    public Customer(String ID, String n, String s, int a) {
        this.ID = ID;
        this.name = n;
        this.sex = s.equalsIgnoreCase("male");
        if(a > 0){
            this.age = a;
        } else {
            this.age = 0;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        } else {
            this.age = 0;
        }
    }
}