package nz.co.zufang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	//TODO define error code

	public NotFoundException() {
        super("The resource you requested does not exist");
    }
}
