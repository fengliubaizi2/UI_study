package com.mean.ui.DesignModel.Prototype;

/**
 * Created by renzhenhua on 2017/10/26.
 * Prototype 原型模式
 */

public class Student implements Cloneable{
    public String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone(){
        Student exp=null;
        try {
            exp=(Student) super.clone();
        } catch (CloneNotSupportedException e){

        }
        return exp;
    }
}
