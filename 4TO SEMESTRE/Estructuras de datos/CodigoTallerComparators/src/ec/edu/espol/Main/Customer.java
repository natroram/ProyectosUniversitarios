/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Main;

/**
 *
 * @author ggmendez
 */
public class Customer {
//public class Customer {

    private String city;
    private String category;
    private String names;
    private int age;

    public Customer() {
    }    

    public Customer(String city, String category, String name, int age) {
        this.city = city;
        this.category = category;
        this.names = name;
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "city=" + city + ", category=" + category + ", names=" + names + ", age=" + age + '}';
    }

}