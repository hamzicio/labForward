package service;

import notebookEntry.model.NoteBook;
import notebookEntry.service.NoteBookService;
import notebookEntry.shared.exceptions.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NotebookServiceTest {

    @InjectMocks
    NoteBookService noteBookService;


    // initializing service
    @BeforeEach
    public  void setup() throws BadRequestException {
        NoteBook noteBook =new NoteBook();
        noteBookService = new NoteBookService(noteBook);
    }

    // test it gets frequency for "word"
    @Test
    public void getFrequencyOfWord() throws BadRequestException {
        Integer frequency = noteBookService.getFrequencyOfWord("word");
        assertEquals(Optional.of((frequency)), Optional.of(1));
    }

    // test it gets similar words for "word"
    @Test
    public void getSimilarWords() throws BadRequestException {
        ArrayList<String> similarWords = noteBookService.getSimilarWords("word");
        assertEquals(similarWords.size(), 1);
    }

    // test it updates notebook entry successfully.
    @Test
    public void updateNoteBookEntry() throws BadRequestException {
        noteBookService.updateNotebookEntry("new entry");
        assertEquals(noteBookService.getFrequencyOfWord("new"), 1);
    }

}
