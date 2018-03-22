package kdg.superteam.userservice.services;

import kdg.superteam.userservice.dom.Account;
import kdg.superteam.userservice.dom.Student;
import kdg.superteam.userservice.dom.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface IAccountService {
    public List<Student> getStudents();

    public List<Account> getAccounts();

    public void addAccount(Account account);

    public void addStudent(Student student);

    public List<Account> getAccountsNotMe(long id);

    public void addStudent(Teacher teacher);

    public Account getAccountByEmail(String email);

    public Student getStudentByEmail(String email);

    public Teacher getTeacherByEmail(String email);

    public Account getAccountById(long id);

    public Student getStudentById(long id);

    public Teacher getTeacherById(long id);

    public void removeAccounts();

    public void removeStudents();

    public void removeTeachers();

    public void removeAccount(long id);

    public void removeStudent(long id);

    public void removeTeacher(long id);
}
