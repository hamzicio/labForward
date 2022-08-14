package notebookEntry.dto.responseDto;

import java.util.ArrayList;

public class SimilarWordsDto {
    ArrayList<String> similarWords;

    public SimilarWordsDto(ArrayList<String> similarWords) {
        this.similarWords = similarWords;
    }

    public ArrayList<String> getSimilarWords() {
        return similarWords;
    }

    public void setSimilarWords(ArrayList<String> similarWords) {
        this.similarWords = similarWords;
    }
}
