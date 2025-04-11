package ch.training.tutorials.controller;

import ch.training.tutorials.dto.CategoryDTO;
import ch.training.tutorials.dto.TutorialDTO;
import ch.training.tutorials.service.TutorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tutorials")
@RequiredArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping()
    public ResponseEntity<List<TutorialDTO>> fetchAll()
    {
        return ResponseEntity.ok(tutorialService.getTutorials());
    }

    @PostMapping("create")
    public ResponseEntity<Void> createTutorial(@RequestBody TutorialDTO tutorialDTO)
    {
        this.tutorialService.createTutorial(tutorialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
