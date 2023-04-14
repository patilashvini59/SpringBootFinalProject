package ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentController {

	@ExceptionHandler(value=StudentEx.class)
	public ResponseEntity<Object> studentExp(StudentEx student) {
		return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
		
	}
}
