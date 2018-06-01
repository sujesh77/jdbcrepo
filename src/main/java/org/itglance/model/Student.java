package org.itglance.model;

public class Student {
    int rollNo;
    String studentName;
    String subject;

    public Student() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student(int id, String studentName, String subject) {
        this.rollNo = id;
        this.studentName = studentName;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student [id=" + rollNo + ", studentName=" + studentName + ", subject=" + subject + "]";
    }

}
