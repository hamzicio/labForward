package notebookEntry.dto.responseDto;

public class ResponseDto {
    String message;

    public ResponseDto(String message) {
        this.message= message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
