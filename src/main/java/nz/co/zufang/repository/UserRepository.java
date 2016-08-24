package nz.co.zufang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nz.co.zufang.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
}