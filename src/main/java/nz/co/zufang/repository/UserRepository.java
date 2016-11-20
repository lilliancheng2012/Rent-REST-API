package nz.co.zufang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nz.co.zufang.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
	User findUserByUsernameAndPassword(String username, String password);
	
	User findUserByUsername(String username);
	
	User findUserByEmail(String email);
}