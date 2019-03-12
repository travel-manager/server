package interfaces.rest;

import org.springframework.http.ResponseEntity;

public interface IAccountController{
    ResponseEntity login(String json);
    ResponseEntity register(String json);
}
