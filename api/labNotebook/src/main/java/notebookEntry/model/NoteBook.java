package notebookEntry.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NoteBook {
    private String noteBookEntry= "Word Words Wor word";
    private HashMap<String, Integer> wordFrequencies= new HashMap<>();

    public String getNoteBookEntry() {
        return noteBookEntry;
    }

    public void setNoteBookEntry(String noteBookEntry) {
        this.noteBookEntry = noteBookEntry;
    }

    public HashMap<String, Integer> getWordFrequencies() {
        return wordFrequencies;
    }

    public void setWordFrequencies(HashMap<String, Integer> wordFrequencies) {
        this.wordFrequencies = wordFrequencies;
    }
}
