package cl.fabioladiaz.sistemacliente.controller;

import cl.fabioladiaz.sistemacliente.exceptions.ClienteNotFound;
import cl.fabioladiaz.sistemacliente.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoResourceFoundException.class) //Se encarga de controlar excepciones
    public ResponseEntity<?> notFoundException(Exception e){//signo de interrogación para un genérico
        //Error error = new Error("URL no existe",HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage());
        ErrorModel error = new ErrorModel();
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(e.getMessage());
        error.setMessege("URL no existe");


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(ClienteNotFound.class) //Se encarga de controlar excepciones
    public ResponseEntity<?> clienteNotFoundException(Exception e){//signo de interrogación para un genérico
        //Error error = new Error("URL no existe",HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage());
        ErrorModel error = new ErrorModel();
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(e.getMessage());
        error.setMessege("Cliente no existe");


        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
