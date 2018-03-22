package kdg.superteam.userservice.services;

import kdg.superteam.userservice.dom.Account;
import kdg.superteam.userservice.dom.Student;
import kdg.superteam.userservice.dom.Teacher;
import kdg.superteam.userservice.repository.AccountRepository;
import kdg.superteam.userservice.repository.StudentRepository;
import kdg.superteam.userservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public List<Teacher> getTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        teacherRepository.findAll().forEach(teachers::add);
        return teachers;
    }

    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Account> getAccountsNotMe(long id){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts.stream().filter(account -> account.getUserId() != id).collect(Collectors.toList());
    }

    public void addStudent(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public Account getAccountByEmail(String email){
        return accountRepository.findByEmail(email);
    }

    public Student getStudentByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public Teacher getTeacherByEmail(String email){
        return teacherRepository.findByEmail(email);
    }

    public Account getAccountById(long id){
        return accountRepository.findOne(id);
    }

    public Student getStudentById(long id){
        return studentRepository.findOne(id);
    }

    public Teacher getTeacherById(long id){
        return teacherRepository.findOne(id);
    }

    public void removeAccounts(){
        accountRepository.deleteAll();
    }

    public void removeStudents(){
        studentRepository.deleteAll();
    }

    public void removeTeachers(){
        teacherRepository.deleteAll();
    }

    public void removeAccount(long id){
        accountRepository.delete(id);
    }

    public void removeStudent(long id){
        studentRepository.delete(id);
    }

    public void removeTeacher(long id){
        teacherRepository.delete(id);
    }

}
