package com.app.nilgiri.Fragments;

public class TeamData {
    private String id;
    private String name;
    private String username;
    private String city;
    private String city_text;
    private String email;
    private String avatar;
    private String sales_active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_text() {
        return city_text;
    }

    public void setCity_text(String city_text) {
        this.city_text = city_text;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSales_active() {
        return sales_active;
    }

    public void setSales_active(String sales_active) {
        this.sales_active = sales_active;
    }
}
