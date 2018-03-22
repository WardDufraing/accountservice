package kdg.superteam.userservice.controller;

import kdg.superteam.userservice.dom.Student;
import kdg.superteam.userservice.dom.Teacher;
import kdg.superteam.userservice.dom.dto.AccountDTO;
import kdg.superteam.userservice.dom.dto.AddressDTO;
import kdg.superteam.userservice.dom.dto.StudentDTO;
import kdg.superteam.userservice.dom.dto.TeacherDTO;
import kdg.superteam.userservice.services.AccountService;
import kdg.superteam.userservice.dom.Account;
import kdg.superteam.userservice.dom.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080", "https://superteam-musicmakers.herokuapp.com", "https://superteam-testgateway.herokuapp.com", "https://superteam-chatservice.herokuapp.com"})
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    public AccountRestController(){
    }

    @PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody AccountDTO accountDTO) {
        Student student = convertToStudentEntity(accountDTO);
        accountService.addStudent(student);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDTO getById(@PathVariable long id) {
        /*StudentDTO studentDTO = convertToStudentDto(accountService.getStudentById(id));
        if(studentDTO == null)
            return convertToTeacherDto(accountService.getTeacherById(id));
        else
            return studentDTO;*/
        return convertToDto(accountService.getAccountById(id));
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountDTO> getAll() {
       return accountService.getAccounts().stream().map(account -> convertToDto(account)).collect(Collectors.toList());
    }

    @GetMapping(value = "/allStudents", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getAllStudents() {
        return accountService.getStudents().stream().map(student -> convertToStudentDto(student)).collect(Collectors.toList());
    }

    @GetMapping(value = "/allTeachers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeacherDTO> getAllTeachers() {
        return accountService.getTeachers().stream().map(teacher -> convertToTeacherDto(teacher)).collect(Collectors.toList());
    }

    @GetMapping(value = "/allNotMe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountDTO> getAllNotMe(@PathVariable long id){
        return accountService.getAccountsNotMe(id).stream().map(account -> convertToDto(account)).collect(Collectors.toList());
    }

    @GetMapping(value = "/email/{email:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDTO getByEmail(@PathVariable String email) {
        /*StudentDTO studentDTO = convertToStudentDto(accountService.getStudentByEmail(email));
        if(studentDTO == null)
            return convertToTeacherDto(accountService.getTeacherByEmail(email));
        else
            return studentDTO;*/
        return convertToDto(accountService.getAccountByEmail(email));
    }

    @GetMapping(value = "/getaddresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDTO> getAddresses() {
        List<Address> addresses = new ArrayList<>();
        for(Account a : accountService.getStudents()){
            addresses.add(a.getAddress());
        }
        return addresses.stream().map(address -> convertToDto(address)).collect(Collectors.toList());
    }

    @GetMapping(value = "/getFirstnameAndId", produces = MediaType.APPLICATION_JSON_VALUE)
        public Map<Long,String> getFirstnameAndId(){
            Map<Long,String> namesAndId = new HashMap<>();
            for(Account account: accountService.getAccounts()){
                namesAndId.put(account.getUserId(),account.getFirstName());
            }
            return namesAndId;
        }

    @GetMapping(value = "/getTopicsForUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getTopicsForUser(@PathVariable long userId){
        return accountService.getAccountById(userId).getTopics();
    }

    @PostMapping(path="/addTopic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTopicToUser(@RequestBody String topic) {
        System.out.println("The addTopic method happend");
        long userIdSender = Long.parseLong(topic.split("_")[1],10);
        long userIdReceiver = Long.parseLong(topic.split("_")[0],10);
        accountService.getAccountById(userIdSender).addTopic(topic);
        accountService.getAccountById(userIdReceiver).addTopic(topic);
    }

    @DeleteMapping(value = "/removeAccount/{userName}")
    public void removeAccount(@PathVariable String userName){
        long userIdToRemove = accountService.getAccountByEmail(userName).getUserId();
        accountService.removeAccount(userIdToRemove);
    }

    @DeleteMapping(value = "/removeStudent/{id}")
    public void removeStudent(@PathVariable Long id){
        Account userIdToRemove = accountService.getAccountById(id);
        accountService.removeStudent(userIdToRemove.getUserId());
    }

    @PostMapping(value="/updateaccount/{account}")
    public void updateAccount(@PathVariable Account account){
        Account updatedAccount = accountService.getAccountById(account.getUserId());
        accountService.addAccount(updatedAccount);
    }

    private AddressDTO convertToDto(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    private Address convertToEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }

    private AccountDTO convertToDto(Account account) {
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
        accountDTO.convertAndSetDateToString(account.getBirthDate());
        return  accountDTO;
    }

    private StudentDTO convertToStudentDto(Account account) {
        StudentDTO studentDTO = modelMapper.map(account, StudentDTO.class);
        studentDTO.convertAndSetDateToString(account.getBirthDate());
        return  studentDTO;
    }

    private TeacherDTO convertToTeacherDto(Account account) {
        TeacherDTO teacherDTO = modelMapper.map(account, TeacherDTO.class);
        teacherDTO.convertAndSetDateToString(account.getBirthDate());
        return  teacherDTO;
    }

    private Account convertToEntity(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        System.out.println(account.getLastName());

        account.convertAndSetBirthdate(accountDTO.getBirthDate());
        return account;
    }

    private Student convertToStudentEntity(AccountDTO studentDTO) {
        Student student = modelMapper.map(studentDTO, Student.class);
        System.out.println(student.getLastName());

        student.convertAndSetBirthdate(studentDTO.getBirthDate());
        return student;
    }

    private Teacher convertToStudentEntity(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        System.out.println(teacher.getLastName());

        teacher.convertAndSetBirthdate(teacherDTO.getBirthDate());
        return teacher;
    }

    /*b*/

}
