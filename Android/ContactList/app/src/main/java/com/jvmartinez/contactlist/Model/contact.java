package com.jvmartinez.contactlist.Model;

/**
 * Created by Juan Martinez on 15/04/17.
 */

public class contact {
    private String name;
    private String lastaName;
    private int number;

    public contact(String name,String lastName,int number){
        this.setName(name);
        this.setLastaName(lastName);
        this.setNumber(number);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastaName() {
        return lastaName;
    }

    public void setLastaName(String lastaName) {
        this.lastaName = lastaName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
