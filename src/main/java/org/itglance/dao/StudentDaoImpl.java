package org.itglance.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itglance.connection.ConnectionFactory;
import org.itglance.model.Student;

public class StudentDaoImpl implements StudentDao {

    private final ConnectionFactory connectionfactoryObject = ConnectionFactory.getInstance();

    private static PreparedStatement prepareStatement;

    private static Statement statement;

    public int insertStudent(Student student) throws SQLException, ClassNotFoundException {
        final String query = "insert into Student values(?,?,?)";
        prepareStatement = connectionfactoryObject.getConnection().prepareStatement(query);
        prepareStatement.setInt(1, student.getRollNo());
        prepareStatement.setString(2, student.getStudentName());
        prepareStatement.setString(3, student.getSubject());
        return prepareStatement.executeUpdate();
    }

    public List<Student> displayStudent() throws SQLException, ClassNotFoundException {
        final List<Student> students = new ArrayList<>();

        final String query = "select * from Student";
        statement = connectionfactoryObject.getConnection().createStatement();
        ResultSet resultset = statement.executeQuery(query);
        while (resultset.next()) {
            Student student = new Student();
            student.setRollNo(resultset.getInt(1));
            student.setStudentName(resultset.getString(2));
            student.setSubject(resultset.getString(3));
            students.add(student);
        }
        return students;
    }

    public Student findOne(int rollno) throws SQLException, ClassNotFoundException {
        final String query = "select *from Student where rollno=" + rollno;
        statement = connectionfactoryObject.getConnection().createStatement();
        ResultSet resultset = statement.executeQuery(query);
        resultset.next();
        int roll = resultset.getInt(1);
        String studentName = resultset.getString(2);
        String subject = resultset.getString(3);
        Student student = new Student(roll, studentName, subject);
        return student;
    }

    public int studentDelete(Student student) throws SQLException, ClassNotFoundException {
        final String query = "delete from student where rollno=" + student.getRollNo();
        Statement statement = connectionfactoryObject.getConnection().createStatement();
        return statement.executeUpdate(query);
    }

    public int studentUpdate(int rollToUpdate, Student student) throws SQLException, ClassNotFoundException {
        final String query = "update student set studentname=? , subject= ? where rollno=?";
        prepareStatement = connectionfactoryObject.getConnection().prepareStatement(query);
        prepareStatement.setString(1, student.getStudentName());
        prepareStatement.setString(2, student.getSubject());
        prepareStatement.setInt(3, student.getRollNo());
        return prepareStatement.executeUpdate();
    }


}
