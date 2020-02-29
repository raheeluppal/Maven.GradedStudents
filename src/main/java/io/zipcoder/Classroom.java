package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom {

    private ArrayList<Student> students;

    private int capacity;

    public Classroom(int maxNumberOfStudents) {
        students = new ArrayList<>(maxNumberOfStudents);
    }

    public Classroom(Student[] students) {
        this.students = new ArrayList<>();
        Collections.addAll(this.students, students);
    }

    public Classroom() {
        students = new ArrayList<>();
    }

    public Student[] getStudents() {
        Student[] temp = new Student[students.size()];
        temp = students.toArray(temp);
        return temp;
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        Double result;

        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.get(i).getNumberOfExamsTaken(); j++) {
                average += students.get(i).getScore(j);
            }
        }
        result = (average / (students.size() * students.get(0).getNumberOfExamsTaken()));

        return result;
    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public void removeStudent(String firstName, String lastName) {

        Student remove = null;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                remove = students.get(i);
            }
        }
        students.remove(remove);
    }

    public Student[] getStudentsByScore() {
        Student[] newStudents = new Student[students.size()];

        for (int i = 0; i < students.size(); i++) {
            newStudents[i] = students.get(i);
        }
        for (int i = 0; i < newStudents.length - 1; i++)
            for (int j = 0; j < newStudents.length - i - 1; j++)

                if (newStudents[j].getAverageExamScores() < newStudents[j + 1].getAverageExamScores()) {
                    Student temp = newStudents[j];
                    newStudents[j] = newStudents[j + 1];
                    newStudents[j + 1] = temp;
                }

        return newStudents;
    }

    public HashMap<Student, String> getGradeBook() {

        LinkedHashMap<Student, String> grades = new LinkedHashMap<>();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getAverageExamScores() > 90) {
                grades.put(students.get(i), "A");

            } else if (students.get(i).getAverageExamScores() < 90 && students.get(i).getAverageExamScores() > 70) {
                grades.put(students.get(i), "B");

            } else if (students.get(i).getAverageExamScores() < 70 && students.get(i).getAverageExamScores() > 50) {
                grades.put(students.get(i), "C");

            } else if (students.get(i).getAverageExamScores() < 50 && students.get(i).getAverageExamScores() > 11) {
                grades.put(students.get(i), "D");

            } else {
                grades.put(students.get(i), "F");

            }
        }
        return grades;

    }
}
