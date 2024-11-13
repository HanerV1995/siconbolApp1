
package com.siconbolApp1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author user
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionNoFound  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExceptionNoFound(String message) {
        super(message);
    }
    
}
