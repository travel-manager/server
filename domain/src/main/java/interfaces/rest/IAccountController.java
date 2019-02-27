package interfaces.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;

public interface IAccountController{

    ResponseEntity login(String json);
    ResponseEntity register(String json);
}
