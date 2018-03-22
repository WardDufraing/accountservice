package kdg.superteam.userservice.repository;

import kdg.superteam.userservice.dom.Student;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends AccountBaseRepository<Student> {

}
