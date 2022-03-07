package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student [] classroom;
    public Classroom (){
        this(30);
    }
    public Classroom(int maxNumberOfStudent){
        classroom=new Student[maxNumberOfStudent];
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
    public void addStudent(Student student){
        for (int i=0;i<classroom.length;i++){
            if (classroom[i] == null){
                classroom[i] = student;
                break;
            }
        }
    }
    public void removeStudent(String firstName, String lastName) {
        for (int i=0;i<classroom.length;i++){
            if (classroom[i].getLastName()==lastName){
                if (classroom[i].getFirstName() == firstName){
                    if (i==classroom.length-1)
                        classroom[i]=null;
                    else {
                        classroom[i] = classroom[i + 1];
                        classroom[i + 1] = null;
                    }
                }
            }
            if (((i != classroom.length-1) && (classroom[i]==null))
                    && (classroom[i+1] != null)){
                classroom[i] = classroom[i + 1];
                classroom[i + 1] = null;
            }
        }
    }
    public Student[] getStudentsByScore(){
        List <Student> studentSortedList = Arrays.asList(classroom);
        Comparator<Student> comparator =
                Comparator.comparingDouble((Student s) -> -s.getAverageExamScore() )
                        .thenComparing(s-> s.getLastName())
                        .thenComparing(s -> s.getFirstName());
        Collections.sort(studentSortedList,comparator);
        return studentSortedList.toArray(new Student[classroom.length]);
    }
    public Map<String, String> getGradeBook(){
        int count=0;
        Double percentile;
        String name;
        Student[] classroomSorted = this.getStudentsByScore();
        Map<String,String> gradeBook = new HashMap<>();
        for (int i=0; i<classroom.length;i++){
            if (classroom[i]==null) {
                count = i + 1;
                break; //Assuming array has null at end and no students between nulls
            }
            else if (classroom.length-1==i)
                count = classroom.length;
        }
        for (int i=0;i<count;i++){
            percentile = ((count-i-1.0)/(count))*100;
            name= classroomSorted[i].getFirstName() +" "+classroomSorted[i].getLastName();
            if (percentile >= 90)
                gradeBook.put(name,"A");
            else if (percentile <= 89 && percentile >= 71)
                gradeBook.put(name,"B");
            else if (percentile <= 70 && percentile >= 50)
                gradeBook.put(name,"C");
            else if (percentile <= 49 && percentile >= 11)
                gradeBook.put(name,"D");
            else
                gradeBook.put(name, "F");
        }
        return gradeBook;
    }
}
