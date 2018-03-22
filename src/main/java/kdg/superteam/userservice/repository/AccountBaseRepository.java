package kdg.superteam.userservice.repository;

import kdg.superteam.userservice.dom.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AccountBaseRepository<T extends Account> extends CrudRepository<T, Long>{
    T findByEmail(String email);
}
