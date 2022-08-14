package notebookEntry.shared.exceptions;

import notebookEntry.dto.responseDto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Component
public class GlobalExceptionHandler extends Exception {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto errorHandle(HttpClientErrorException ex) {
        ResponseDto errorResponse = new ResponseDto(ex.getMessage());
        return errorResponse;
    }
}
