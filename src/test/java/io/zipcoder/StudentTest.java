package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void studentConstructor2Test(){
        //Given
        String firstName = "first";
        String lastName = "last";

        //When
        Student student = new Student(firstName, lastName);

        //Then
        Assert.assertTrue(student.getLastName()!=null);
    }
    @Test
    public void studentConstructor2Test1(){

        //Given
        String firstName = "Wei";
        String lastName = "Zheng";

        //When
        Student student = new Student(firstName, lastName);

        //Then
        Assert.assertFalse(student.getFirstName()==null);
    }
    @Test
    public void studentConstructor3Test(){

        //Given
        String firstName = "first";
        String lastName = "last";
        Double[] examScore = new Double[]{100.0,90.0,80.0};

        //When
        Student student = new Student(firstName, lastName, examScore);

        //Then
        Assert.assertFalse(student.getExamScores()==null);
    }
    @Test
    public void studentConstructor3Test1(){
        //Given
        String firstName = "Wei";
        String lastName = "Zheng";
        Double[] examScore = new Double[]{100.0,90.0,80.0};
        //When
        Student student = new Student(firstName, lastName, examScore);

        //Then
        Assert.assertTrue(student.getExamScores()!=null);
    }
    @Test
    public void getStudentNameTest(){
        //Given
        String firstName = "first";
        //When
        Student student = new Student(firstName, null);

        //Then
        Assert.assertTrue(student.getFirstName() == "first");
    }
    @Test
    public void getStudentNameTest1(){
        //Given
        String firstName = "Wei";
        //When
        Student student = new Student(firstName, null);

        //Then
        Assert.assertFalse(student.getFirstName()==null);
    }
    @Test
    public void setStudentNameTest(){
        //Given
        Student student = new Student(null, null);
        String first = "first", last="last";
        //When
        student.setFirstName(first);
        student.setLastName(last);

        //Then
        Assert.assertEquals(first,student.getFirstName());
        Assert.assertEquals(last,student.getLastName());
    }
    @Test
    public void setStudentNameTest1(){
        //Given
        Student student = new Student(null, null);
        String first = "wei", last="zheng";
        //When
        student.setFirstName(first);
        student.setLastName(last);

        //Then
        Assert.assertNotNull(student.getFirstName());
        Assert.assertNotNull(student.getLastName());
    }
    @Test
    public void getNumberOfExamTest(){
        //Given
        Student student = new Student(null, null, new Double[]{100.0});

        //When
        int actual= student.getNumberOfExamsTaken();

        //Then
        Assert.assertEquals(actual,1);
    }
    @Test
    public void getNumberOfExamTest1(){
        //Given
        Student student = new Student(null, null);

        //When
        int actual= student.getNumberOfExamsTaken();

        //Then
        Assert.assertNotEquals(actual,1);
    }
    @Test
    public void getExamScoreTest(){}{
        //Given
        Student student = new Student(null, null, new Double[]{100.0});

        //When
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertNotNull(examScore);
    }
    @Test
    public void getExamScoreTest2(){}{
        //Given
        Student student = new Student(null, null, new Double[]{50.0});

        //When
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertTrue(examScore.contains("50"));
    }
    @Test
    public void addExamScore1Test(){
        //Given
        Student student = new Student(null, null);

        //When
        student.addExamScore(50.0);
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertTrue(examScore.contains("50"));
    }
    @Test
    public void addExamScore1Test1(){
        //Given
        Student student = new Student(null, null);

        //When
        student.addExamScore(50.0);
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertFalse(examScore.contains("100"));
    }
    @Test
    public void addExamScore2Test(){
        //Given
        Student student = new Student(null, null, new Double[] {50.0});

        //When
        student.setExamScore(1,100.0);
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertTrue(examScore.contains("100"));
    }
    @Test
    public void addExamScore2Test1(){
        //Given
        Student student = new Student(null, null, new Double[] {50.0});

        //When
        student.setExamScore(1,70.0);
        String examScore= student.getExamScores();
        System.out.println(examScore);

        //Then
        Assert.assertFalse(examScore.contains("50"));
    }
    @Test
    public void getAverageScoreTest(){
        //Given
        Student student = new Student(null, null);

        //When
        student.addExamScore(50.0);
        double expectedAverage=50.0, actual=student.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage,actual);
    }
    @Test
    public void getAverageScoreTest1(){
        //Given
        Student student = new Student(null, null,
                new Double[] {100.0, 0.0});

        //When
        double expectedAverage=50.0, actual=student.getAverageExamScore();

        //Then
        Assert.assertFalse(student.getAverageExamScore()==100.0);
        Assert.assertEquals(expectedAverage,actual);
    }
    @Test
    public void toStringTest(){
        //Given
        Student student = new Student(null, null,
                new Double[] {100.0, 0.0});
        //When
        String s = student.toString();
        System.out.println(s);

        //Then
        Assert.assertTrue(s.contains("100"));
    }
    @Test
    public void toStringTest1(){
        //Given
        Student student = new Student(null, null,
                new Double[] {100.0, 0.0});
        //When
        String s = student.toString();
        System.out.println(s);

        //Then
        Assert.assertFalse(s.contains("70"));
    }
}