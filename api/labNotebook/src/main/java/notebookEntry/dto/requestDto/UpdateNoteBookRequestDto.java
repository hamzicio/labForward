package notebookEntry.dto.requestDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateNoteBookRequestDto {

    @NotNull
    @Size(min = 1,message = "Minimum 1 is length required for new notebook entry")
    String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
