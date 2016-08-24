package nz.co.zufang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	//TODO define error code

	public UserExistException() {
        super("The user is already registered.");
    }
}
