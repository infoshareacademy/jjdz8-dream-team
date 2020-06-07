package com.infoshareacademy.domain;

public class User {

  private Long id;

  private String name;
  private double grade;


  public User() {

  }

  public User(Long id, String name, double grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  public User(String name, double grade) {
    this.name = name;
    this.grade = grade;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public User(Long id, String name, int grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}