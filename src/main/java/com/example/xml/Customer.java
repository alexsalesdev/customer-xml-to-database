package com.example.xml;

import java.util.Map;

/**
 * Created by asales on 23/1/2016.
 */
public class Customer {
    private String name;
    private Integer age;
    private Map<String, Object> other;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", other=" + other +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }
}
