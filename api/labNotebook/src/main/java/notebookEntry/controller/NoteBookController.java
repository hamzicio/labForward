package notebookEntry.controller;

import notebookEntry.dto.responseDto.FrequencyDto;
import notebookEntry.dto.responseDto.FrequencyWSimilarWordsDto;
import notebookEntry.dto.responseDto.ResponseDto;
import notebookEntry.dto.requestDto.UpdateNoteBookRequestDto;
import notebookEntry.dto.responseDto.SimilarWordsDto;
import notebookEntry.service.NoteBookService;
import notebookEntry.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@RequestMapping("/v1/notebook/")
public class NoteBookController {

    @Autowired
    NoteBookService noteBookService;

    // returns frequency of a word by passing word in parameters
    @GetMapping("getFrequency/{word}")
    public ResponseEntity<FrequencyDto> getFrequencyOfWord(@PathVariable String word) throws BadRequestException {
        Integer frequency =noteBookService.getFrequencyOfWord(word);
        return ResponseEntity.ok(new FrequencyDto(frequency));
    }

    // returns similar words by passing word in parameters
    @GetMapping("getSimilarWords/{word}")
    public ResponseEntity<SimilarWordsDto> getSimilarWords(@PathVariable String word) throws BadRequestException {
        ArrayList<String> response=noteBookService.getSimilarWords(word);
        return ResponseEntity.ok(new SimilarWordsDto(response));
    }

    // returns frequency and similar words for a particular word passed in params
    @GetMapping("getFrequencyWSimilarWords/{word}")
    public ResponseEntity<FrequencyWSimilarWordsDto> getFrequencyWithSimilarWords(@PathVariable String word) throws BadRequestException {
        Integer frequency = noteBookService.getFrequencyOfWord(word);
        ArrayList<String> similarWords=noteBookService.getSimilarWords(word);
        return ResponseEntity.ok(new FrequencyWSimilarWordsDto(frequency,similarWords));
    }

    // updates current notebook entry by passing request body in post request
    @PostMapping("updateNoteBook")
    public ResponseEntity<ResponseDto> updateNoteBookEntry(@Valid @RequestBody UpdateNoteBookRequestDto updateNoteBookRequestDto) throws BadRequestException {
        noteBookService.updateNotebookEntry(updateNoteBookRequestDto.getWord());
        return ResponseEntity.ok(new ResponseDto("Notebook Updated"));
    }

}
