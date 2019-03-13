package interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface ICRUDController {

    ResponseEntity create(String jsonString);

    ResponseEntity read(String jsonString);

    ResponseEntity update(String jsonString);

    ResponseEntity delete(String jsonString);
}
