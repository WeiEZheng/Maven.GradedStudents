package io.zipcoder;

public class Classroom {
    Student [] classroom;
    public Classroom (){
        this(30);
    }
    public Classroom(int maxNumberOfStudent){
        classroom=new Student[30];
    }
    public Classroom (Student[] studentsList){
        classroom=studentsList;
    }
    public Student[] getStudents(){
        return classroom;
    }
    public double getAverageExamScore(){
        double average=0;
        for (int i=0;i<classroom.length;i++){
            average+=classroom[i].getAverageExamScore();
        }
        return average/classroom.length;
    }
    //addStudent(Student student)
    //removeStudent(String firstName, String lastName) move null to end
    //getStudentsByScore() sort student by score
//    getGradeBook()
//    The class Classroom should define a method getGradeBook() which returns a mapping of Student objects to a respective letter grade determined by creating a grading curve such that
//    An A is awarded to students whose class average is in the upper 10th percentile.
//    A B is awarded to students whose class average falls between the upper 11th and 29th percentile.
//    A C is awarded to students whose class average falls between the upper 30th and 50th percentile.
//    A D is awarded to students whose class average falls between the lower 51st and 89th percentile.
//    An F is awarded to students whose class average is in the lower 11th percentile.
}
