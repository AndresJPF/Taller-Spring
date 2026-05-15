package taller.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/*
    @ControllerAdvice intercepta los errores de toda la aplicacion
    en un solo lugar, en vez de manejarlos en cada controlador.
*/
@ControllerAdvice
public class GlobalExceptionHandler {

    // Se ejecuta cuando no se encuentra un producto (404)
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> manejarProductoNoEncontrado(ProductNotFoundException ex) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    // Se ejecuta cuando los datos enviados no pasan las validaciones (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException ex) {

        Map<String, String> errores = new HashMap<>();

        // Recorre cada campo que fallo la validacion y guarda el mensaje de error
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }
}
