package org.itglance.dao;

import java.sql.SQLException;
import java.util.List;

import org.itglance.model.Student;

public interface StudentDao {

    int insertStudent(Student student) throws SQLException, ClassNotFoundException;

    List<Student> displayStudent() throws SQLException, ClassNotFoundException;

    Student findOne(int rollno) throws SQLException, ClassNotFoundException;

    int studentDelete(Student student) throws SQLException, ClassNotFoundException;

    int studentUpdate(int rollToUpdate, Student student) throws SQLException, ClassNotFoundException;

}
