package notebookEntry.service;

import notebookEntry.model.NoteBook;
import notebookEntry.shared.exceptions.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static notebookEntry.shared.constants.Exception.INTERNAL_SERVER_ERROR;

@Service
public class NoteBookService {

    final
    NoteBook noteBook;

    Logger logger = LoggerFactory.getLogger(NoteBookService.class);

    public NoteBookService(NoteBook noteBook) throws BadRequestException {
        this.noteBook = noteBook;
        this.updateNotebookEntry(this.noteBook.getNoteBookEntry());
    }

    public int getFrequencyOfWord(String word) throws BadRequestException {
        try {
            // checks and returns frequency if frequencies are present for a particular word from hashmap
            if (noteBook.getWordFrequencies() != null && noteBook.getWordFrequencies().containsKey(word.strip())) {
                return noteBook.getWordFrequencies().get(word.strip());
            }

            // returning 0 if not initialized or not found.
            return 0;
        }
        catch(Exception e) {
            logger.error(e.getMessage());
            throw new BadRequestException(INTERNAL_SERVER_ERROR);
        }
    }

    //gets similar words using distance formula
    public ArrayList<String> getSimilarWords(String word) throws BadRequestException {
        try {
            ArrayList<String> similarWords = new ArrayList<>();

            for (String entryWord : noteBook.getWordFrequencies().keySet()) {
                // not including 0 because excluding exact match.
                if (getLevenshteinDistance(entryWord, word) == 1) {
                    similarWords.add(entryWord);
                }
            }

            return similarWords;
        }
        catch(Exception e){
            logger.error(e.getMessage());
            throw new BadRequestException(INTERNAL_SERVER_ERROR);
        }
    }

    // updates notebook entry followed by updating frequencies of entire entry
    public void updateNotebookEntry(String word) throws BadRequestException {
        try {
            this.noteBook.setNoteBookEntry(word);
            this.updateFrequencies();
        }
        catch(Exception e) {
            logger.error(e.getLocalizedMessage());
            throw new BadRequestException(e.getLocalizedMessage());
        }
    }

    // calculating levenshtein distance using table based approach
    private int getLevenshteinDistance(String word, String anotherWord) {
        int[][] dp = new int[word.length() + 1][anotherWord.length() + 1];

        for (int i = 0; i <= word.length(); i++) {
            for (int j = 0; j <= anotherWord.length(); j++) {

                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = minimumEdits(dp[i - 1][j - 1]
                                    + (word.charAt(i - 1) == anotherWord.charAt(j - 1) ? 0 : 1),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[word.length()][anotherWord.length()];
    }

    private int minimumEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(
                Integer.MAX_VALUE);
    }

    // updating frequency of each word on updating notebook entry
    private void updateFrequencies() {
        this.noteBook.setWordFrequencies(new HashMap<>());
        String[] words = this.noteBook.getNoteBookEntry().split(" ");
        for (String word: words) {
            word = word.strip();
            if (this.noteBook.getWordFrequencies().containsKey(word)) {
                this.noteBook.getWordFrequencies().put(word, this.noteBook.getWordFrequencies().get(word) + 1);
            }
            else {
                this.noteBook.getWordFrequencies().put(word, 1);
            }
        }
    }


}
