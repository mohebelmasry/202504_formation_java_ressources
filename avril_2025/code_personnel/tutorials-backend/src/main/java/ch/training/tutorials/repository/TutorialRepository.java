package ch.training.tutorials.repository;

import ch.training.tutorials.dto.CategoryDTO;
import ch.training.tutorials.entity.TutorialEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, UUID> {


}
