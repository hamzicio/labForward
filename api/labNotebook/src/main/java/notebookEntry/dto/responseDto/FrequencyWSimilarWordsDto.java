package notebookEntry.dto.responseDto;
import java.util.ArrayList;

public class FrequencyWSimilarWordsDto {
    Integer frequency;
    ArrayList<String> similarWords;

    public FrequencyWSimilarWordsDto(Integer frequency, ArrayList<String> similarWords) {
        this.frequency = frequency;
        this.similarWords = similarWords;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public ArrayList<String> getSimilarWords() {
        return similarWords;
    }

    public void setSimilarWords(ArrayList<String> similarWords) {
        this.similarWords = similarWords;
    }
}
