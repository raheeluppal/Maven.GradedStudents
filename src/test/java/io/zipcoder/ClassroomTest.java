package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class ClassroomTest {
    private static final Logger LOGGER = Logger.getLogger(StudentTest.class.getName());

    @Test
    public void ClassroomTest1() {

        // : Given

        ArrayList<Double> s1score = new ArrayList<>();
        s1score.add(100.0);
        s1score.add(150.0);

        ArrayList<Double> s2score = new ArrayList<>();
        s2score.add(225.0);
        s2score.add(25.0);


        Student s1 = new Student("student", "one", s1score);
        Student s2 = new Student("student", "two", s2score);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        LOGGER.info(String.valueOf(output));
    }

    @Test
    public void ClassroomTest2() {

        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>();
        examScores.add(100.0);
        examScores.add(150.0);
        examScores.add(250.0);
        examScores.add(0.0);

        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        LOGGER.info("===========================");
        LOGGER.info(preEnrollmentAsString);
        LOGGER.info("===========================");
        LOGGER.info(postEnrollmentAsString);
    }

    @Test
    public void ClassroomTest3() {
        ArrayList<Double> scores = new ArrayList<>();
        Classroom classroom = new Classroom();


        classroom.addStudent(new Student("Mark", "X", scores));
        classroom.addStudent(new Student("John", "Doe", scores));
        classroom.removeStudent("John","Doe");

        Student[] temp = classroom.getStudents();

        Integer actual = temp.length;

        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void ClassroomTest4() {

        Classroom classroom = new Classroom();
        ArrayList<Double> markScores = new ArrayList<>();
        markScores.add(100.0);
        markScores.add(150.0);
        markScores.add(250.0);
        markScores.add(50.0);

        ArrayList<Double> johnScores = new ArrayList<>();
        johnScores.add(10.0);
        johnScores.add(5.0);
        johnScores.add(25.0);
        johnScores.add(19.0);


        classroom.addStudent(new Student("John", "Doe", johnScores));
        Student expected = (new Student("Mark", "X", markScores));
        classroom.addStudent(expected);

        String actual = classroom.getStudentsByScore()[0].getFirstName();
        String expectedFirstName = "Mark";

        Assert.assertEquals(expectedFirstName,actual);
    }

    @Test
    public void ClassroomTest5(){

        Classroom classroom = new Classroom();
        ArrayList<Double> markScores = new ArrayList<>();
        markScores.add(100.0);
        markScores.add(70.0);
        markScores.add(80.0);
        markScores.add(50.0);

        ArrayList<Double> johnScores = new ArrayList<>();
        johnScores.add(10.0);
        johnScores.add(5.0);
        johnScores.add(25.0);
        johnScores.add(19.0);

        Student John = (new Student("John", "Doe", johnScores));
        Student Mark =(new Student("Mark", "X", markScores));
        classroom.addStudent(John);
        classroom.addStudent(Mark);

        String johnExpected = "D";
        String markExpected = "B";

        String johnActual = classroom.getGradeBook().get(John);
        String markActual = classroom.getGradeBook().get(Mark);

        Assert.assertEquals(johnExpected,johnActual);
        Assert.assertEquals(markExpected,markActual);

        LOGGER.info( Mark.getAverageExamScores().toString() );
        LOGGER.info( John.getAverageExamScores().toString());


    }
}