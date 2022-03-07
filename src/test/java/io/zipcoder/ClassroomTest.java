package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class ClassroomTest {
    //Given
    public Student student = new Student(null, null,
            new Double[]{100.0});
    public Student student1 = new Student("first", "last",
            new Double[]{0.0});

    @Test
    public void classroomConstructor0Test() {
        //Given
        Classroom classroom = new Classroom();
        //When
        int size = classroom.getStudents().length;
        //Then
        Assert.assertEquals(30, size);
    }

    @Test
    public void classroomConstructor1Test() {
        //Given
        Classroom classroom = new Classroom(30);
        //When
        int size = classroom.getStudents().length;
        //Then
        Assert.assertEquals(30, size);
    }

    @Test
    public void classroomConstructor1Test1() {
        //Given
        Classroom classroom = new Classroom(20);
        //When
        int size = classroom.getStudents().length;
        //Then
        Assert.assertNotEquals(30, size);
    }

    @Test
    public void classroomConstructorTest() {
        //Given
        Student[] studentList = new Student[]{student, student1};
        Classroom classroom = new Classroom(studentList);
        //When
        int size = classroom.getStudents().length;
        //Then
        Assert.assertNotEquals(30, size);
    }

    @Test
    public void classroomConstructorTest1() {
        //Given
        Student[] studentList = new Student[]{student};
        Classroom classroom = new Classroom(studentList);
        //When
        int size = classroom.getStudents().length;
        //Then
        Assert.assertEquals(1, size);
    }

    @Test
    public void getStudentsTest() {
        //Given
        Student[] studentList = new Student[]{student, student1};
        Classroom classroom = new Classroom(studentList);
        //When
        int size = classroom.getStudents().length;
        Student[] expected = new Student[]{student, student1};
        Student[] actual = classroom.getStudents();
        //Then
        Assert.assertNotEquals(30, size);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsTest1() {
        //Given
        Student[] studentList = new Student[]{student};
        Classroom classroom = new Classroom(studentList);
        //When
        int size = classroom.getStudents().length;
        Student[] notExpected = new Student[]{student, student1};
        Student[] actual = classroom.getStudents();
        //Then
        Assert.assertEquals(1, size);
        Assert.assertNotEquals(notExpected, actual);
    }

    @Test
    public void getExamAverage() {
        //Given
        Student[] studentList = new Student[]{student, student1};
        Classroom classroom = new Classroom(studentList);
        //When
        Double actual = classroom.getAverageExamScore();
        Double expected = 50.0;
        //Then
        Assert.assertEquals(expected, actual, 0);
    }
    @Test
    public void getExamAverage1() {
        //Given
        Student[] studentList = new Student[]{student};
        Classroom classroom = new Classroom(studentList);
        //When
        Double actual = classroom.getAverageExamScore();
        Double notexpected = 50.0;
        //Then
        Assert.assertNotEquals(notexpected, actual);
    }
    @Test
    public void addStudentTest(){
        //Given
        Student[] studentList;
        Classroom classroom = new Classroom();
        //When
        int count=0;
        classroom.addStudent(student1);
        classroom.addStudent(student);
        studentList = classroom.getStudents();
        for (int i=0;i<studentList.length;i++){
            if (studentList[i]!=null){
                count++;
            }
        }
        //Then
        Assert.assertEquals(2,count);
    }
    @Test
    public void addStudentTest1(){
        //Given
        Student[] studentList;
        Classroom classroom = new Classroom();
        //When
        int count=0;
        classroom.addStudent(student);
        studentList = classroom.getStudents();
        for (int i=0;i<studentList.length;i++){
            if (studentList[i]!=null){
                count++;
            }
        }
        //Then
        Assert.assertNotEquals(2,count);
    }
    @Test
    public void removeStudentTest(){
        //Given
        Student[] studentList= new Student[]{student,student1},studentList1;
        Classroom classroom = new Classroom(studentList);
        //When
        classroom.removeStudent("first","last");
        int count=0;
        studentList1 = classroom.getStudents();
        for (int i=0;i<studentList.length;i++){
            if (studentList1[i]!=null){
                count++;
            }
        }
        //Then
        Assert.assertNotEquals(2,count);
    }
    @Test
    public void removeStudentTest1(){
        //Given
        Student[] studentList= new Student[]{student1},studentList1;
        Classroom classroom = new Classroom(studentList);
        //When
        classroom.removeStudent("first","last");
        int count=0;
        studentList1 = classroom.getStudents();
        for (int i=0;i<studentList.length;i++){
            if (studentList1[i]!=null){
                count++;
            }
        }
        //Then
        Assert.assertEquals(0,count);
    }
    @Test
    public void getStudentByScore(){
        //Given
        Student[] studentList= new Student[]{student1,student},studentList1;
        Classroom classroom = new Classroom(studentList);
        //When
        studentList1 = classroom.getStudentsByScore();
        //Then
        Assert.assertEquals(student,studentList1[0]);
    }
    @Test
    public void getStudentByScore1(){
        //Given
        student.setLastName("z");
        student.setFirstName("z");
        student1.setExamScore(1, 100);
        Student[] studentList= new Student[]{student1,student},studentList1;
        Classroom classroom = new Classroom(studentList);
        //When
        studentList1 = classroom.getStudentsByScore();
        //Then
        Assert.assertNotEquals(student1,studentList1[1]);
    }
    @Test
    public void getGradeBook(){
        //Given
        student.setLastName("z");
        student.setFirstName("z");
        Student[] studentList= new Student[]{student1,student},studentList1;
        Classroom classroom = new Classroom(studentList);
        //When
        Map<String, String> gradeBook= classroom.getGradeBook();
        //Then
        Assert.assertEquals("C",gradeBook.get("z z"));
        Assert.assertEquals("F",gradeBook.get("first last"));
    }
}
