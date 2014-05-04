/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Jeffrey
 */
public class Patient {
    private String first_name;
    private String last_name;
    private String initial;
    private String address;
    private String city;
    private String state;
    private int month;
    private int day;
    private String year;
    private String gender;
    
    public Patient(){
        this.first_name = "";
        this.last_name = "";
        this.initial = "";
        this.address = "";
        this.city = "";
        this.state = "";
        this.month = 1;
        this.day = 1;
        this.year = "";
        this.gender = "";
    }
    
    public void set_first_name(String first_name) {
        this.first_name = first_name;
    }

    public void set_last_name(String last_name) {
        this.last_name = last_name;
    }

    public void set_initial(String middle_initial) {
        this.initial = middle_initial;
    }

    public void set_address(String address) {
        this.address = address;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public void set_state(String state) {
        this.state = state;
    }

    public void set_month(int month) {
        this.month = month;
    }

    public void set_day(int day) {
        this.day = day;
    }

    public void set_year(String year) {
        this.year = year;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }

    public String get_first_name() {
        return first_name;
    }

    public String get_last_name() {
        return last_name;
    }

    public String get_initial() {
        return initial;
    }

    public String get_address() {
        return address;
    }

    public String get_city() {
        return city;
    }

    public String get_state() {
        return state;
    }

    public int get_month() {
        return month;
    }

    public int get_day() {
        return day;
    }

    public String get_year() {
        return year;
    }

    public String get_gender() {
        return gender;
    }
}
