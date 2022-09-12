package br.com.fiap.broker.dronemonitorproducer.vo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }

    public NotFoundException(String msg) {
        super(404, msg);
        this.code = code;
    }
}
