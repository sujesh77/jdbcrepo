package org.itglance.connection;

import org.itglance.dao.StudentDaoImpl;
import org.itglance.model.Student;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

public class TestJdbc {

    StudentDaoImpl studentDao = new StudentDaoImpl();

    @Test
    public void testInsertStudent() throws SQLException, ClassNotFoundException {

        Student student = new Student(9, "Blue", "music");
        int i = studentDao.insertStudent(student);

        assertEquals(1, i);
    }

    @Test
    public void testDisplayStudent() throws SQLException, ClassNotFoundException {

        List<Student> students = studentDao.displayStudent();

        assertNotNull(students);

    }

    @Test
    public void testDeleteStudent() throws SQLException, ClassNotFoundException {
        Student student = studentDao.findOne(6);
        int i = studentDao.studentDelete(student);

        assertEquals(1, i);

    }

    @Test
    public void testUpdateStudent() throws SQLException, ClassNotFoundException {
        int i = studentDao.studentUpdate(5, new Student(5, "rock", "music"));
        assertEquals(1, i);
    }

    @Test
    public void testSearchStudent()throws SQLException,ClassNotFoundException{
        Student student=studentDao.findOne(1);

        assertNotNull(student);

    }

}
