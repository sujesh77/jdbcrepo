package org.itglance.view;

import java.util.List;
import java.util.Scanner;

import org.itglance.dao.StudentDao;
import org.itglance.dao.StudentDaoImpl;
import org.itglance.model.Student;

public class StudentView {
    private Scanner scanner = new Scanner(System.in);

    private final StudentDao studentDao = new StudentDaoImpl();

    public void mainProcess() {
        String shouldContinue = "";
        do {
            System.out.println("Hello User.What do you want to do ?");
            System.out.println("1.add student");
            System.out.println("2.display students");
            System.out.println("3.delete student");
            System.out.println("4.update student info");
            System.out.println("5.search student by id");
            switch (scanner.next()) {
                case "add": {
                    System.out.println("enter roll");
                    int rollno = scanner.nextInt();
                    System.out.println("enter StudentName");
                    String studentName = scanner.next();
                    System.out.println("subject");
                    String subject = scanner.next();
                    Student student = new Student(rollno, studentName, subject);
                    try {
                        int i = studentDao.insertStudent(student);
                        if (i > 0) {
                            System.out.println("Student has been added to the database");
                        } else {
                            System.out.println("failed");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }

                case "display": {
                    try {
                        List<Student> students = studentDao.displayStudent();
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }

                case "delete": {
                    System.out.println("Enter which rollno you want to delete?");
                    int rollToDelete = scanner.nextInt();
                    try {
                        Student student = studentDao.findOne(rollToDelete);
                        if (student != null) {
                            int i = studentDao.studentDelete(student);
                            if (i > 0) {
                                System.out.println("Student has been deleted from the database");
                            } else {
                                System.out.println("failed to delete");
                            }
                        } else {
                            System.out.println("student id not found");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case "update": {
                    System.out.println("enter which rollno you want to update?");
                    int rollToUpdate = scanner.nextInt();
                    try {
                        Student student = studentDao.findOne(rollToUpdate);
                        if (student != null) {
                            System.out.println("enter new student name");
                            student.setStudentName(scanner.next());
                            System.out.println("enter new subject");
                            student.setSubject(scanner.next());
                            int i = studentDao.studentUpdate(rollToUpdate, student);

                            if (i > 0) {
                                System.out.println("Student has been updated");
                            } else {
                                System.out.println("Student has not been updated");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                }

                case "search": {
                    System.out.println("enter which roll no you want to search");
                    int rollToSearch = scanner.nextInt();
                    try {
                        Student student = studentDao.findOne(rollToSearch);
                        System.out.println(student);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                default: {
                    System.out.println("you havenot selected a number");
                }
            }
            shouldContinue = isContinue();
        } while (shouldContinue.equalsIgnoreCase("yes"));

    }

    private String isContinue() {
        String shouldContinue;
        System.out.println("Do you want to continue? ");
        shouldContinue = scanner.next();
        return shouldContinue;
    }
}
