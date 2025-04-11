package ch.training.tutorials.service;

import ch.training.tutorials.dto.CategoryDTO;
import ch.training.tutorials.entity.CategoryEntity;
import ch.training.tutorials.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public List<CategoryDTO> getCategories()
    {
        return this.categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, CategoryDTO.class))
                .toList();
    }

    public void createCategory(CategoryDTO categoryDTO)
    {
        this.categoryRepository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
    }
}
