package ch.training.tutorials.controller;

import ch.training.tutorials.dto.CategoryDTO;
import ch.training.tutorials.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> fetchAll()
    {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping("create")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        this.categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
