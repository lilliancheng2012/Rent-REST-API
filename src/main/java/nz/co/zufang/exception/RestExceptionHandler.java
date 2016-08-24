package nz.co.zufang.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by david on 4/7/2016.
 */
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = { Exception.class, RuntimeException.class })
    @ResponseBody
    public ResponseEntity<Map<String,String>> handleGenericException(Exception ex, WebRequest request) {
    	
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("message", ex.getMessage());
        //TODO add response code
        ex.printStackTrace();
        LOGGER.error(ex.getMessage());
        
        return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
    }
}
