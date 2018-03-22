package kdg.superteam.userservice.repository;

import kdg.superteam.userservice.dom.Teacher;

import javax.transaction.Transactional;

@Transactional
public interface TeacherRepository extends AccountBaseRepository<Teacher> {

}
