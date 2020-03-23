package com.example.demo.domain.basic.clone;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-03-02 09:55
 */
public class Student implements Cloneable {

  private String name;
  private int age;

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
  protected Student clone() throws CloneNotSupportedException {
    return (Student) super.clone();
  }

  @Override
  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    //
    Student student = new Student();
    student.setAge(1);
    student.setName("wenky");
    Student student1 = student;
    student1.setAge(2);
    student1.setName("lucy");
    System.out.println(student);
    System.out.println(student1);

    Student student2 = student1.clone();
    student2.setName("mack");
    student2.setAge(3);
    System.out.println(student1);
    System.out.println(student2);
  }
}
