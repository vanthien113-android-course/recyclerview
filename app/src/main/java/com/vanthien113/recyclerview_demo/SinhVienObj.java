package com.vanthien113.recyclerview_demo;

/**
 * Created by vanthien113 on 2/29/20.
 */
public class SinhVienObj {
    private String Name;
    private String Address;

    public SinhVienObj(String name, String address) {
        Name = name;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
