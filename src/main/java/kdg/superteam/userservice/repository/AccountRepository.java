package kdg.superteam.userservice.repository;

import kdg.superteam.userservice.dom.Account;
import kdg.superteam.userservice.dom.Student;
import kdg.superteam.userservice.dom.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AccountRepository extends AccountBaseRepository<Account> {

}
