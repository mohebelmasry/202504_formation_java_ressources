package ch.training.tutorials.service;

import ch.training.tutorials.dto.CategoryDTO;
import ch.training.tutorials.dto.TutorialDTO;
import ch.training.tutorials.entity.CategoryEntity;
import ch.training.tutorials.entity.TutorialEntity;
import ch.training.tutorials.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService {

    private final TutorialRepository tutorialRepository;

    private final ModelMapper modelMapper;

    public List<TutorialDTO> getTutorials()
    {
        return tutorialRepository.findAll()
                .stream()
                .map(tutorial -> modelMapper.map(tutorial, TutorialDTO.class))
                .toList();
    }

    public void createTutorial(TutorialDTO tutorialDTO)
    {
        this.tutorialRepository.save(modelMapper.map(tutorialDTO, TutorialEntity.class));
    }
}
