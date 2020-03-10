package com.infoshareacademy.Kasia;

    import java.util.ArrayList;
import java.util.Arrays;

    public class Student {
        double[] arr5;

        public double[] getArr5() {
            return arr5;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "arr5=" + Arrays.toString(arr5) +
                    ", grades=" + grades +
                    ", name='" + name + '\'' +
                    '}';
        }


        private ArrayList<Double> grades = new ArrayList<>();
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Double> getGrades() {
            return grades;
        }

        public void addGrade(double grade) {
            grades.add(grade);
        }


        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubject() {
            return this.subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        double[] a = new double[0];
        double[] last;

        public Student() {

        }

        public static double[] getLast() {
            double[] a = new double[0];

            return a;
        }

        public static double[] getA() {
            double[] a = new double[0];

            return a;
        }


        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        private int id;
        private String subject;
        private int grade;
        private String comment;
    }
