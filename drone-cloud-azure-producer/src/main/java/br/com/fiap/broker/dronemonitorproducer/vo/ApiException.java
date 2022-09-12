package br.com.fiap.broker.dronemonitorproducer.vo;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApiException extends RuntimeException {

    private int code;
    
    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
