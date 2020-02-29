package io.zipcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();

        sb.append("Exam scores :");

        for (int i = 0; i < examScores.size(); i++) {

            sb.append("\n Exam " + (i + 1) + " -> " + examScores.get(i));
        }
        return sb.toString();
    }

    public void addExamScore(Double examScore) {
        examScores.add(examScore);

    }

    public void setExamScore(Integer examNumber, Double newScore) {

        examScores.set(examNumber - 1, newScore);

    }

    public Double getAverageExamScores() {

        Double average = 0.0;
        Double result;

        for (int i = 0; i < examScores.size(); i++) {
            average += examScores.get(i);
        }
        result = average / examScores.size();

        return result;

    }

    public Double getScore(int index){
        return examScores.get(index);
        }

    @Override
    public String toString() {
        return ("Student Name: " + firstName +" " + lastName + "\n >Average Score:" +getAverageExamScores() +"\n>Exam Scores"+getExamScores() );
    }
}
