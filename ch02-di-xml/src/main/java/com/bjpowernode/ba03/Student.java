package com.bjpowernode.ba03;

public class Student {
    private String name;
    private int age;

    //声明一个引用leix
    private School school;

    public void setSchool(School school) {
        this.school = school;
    }

    public Student() {
    }

    public Student(String name, int age, School school) {
        System.out.println("====Student有参构造方法====");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
