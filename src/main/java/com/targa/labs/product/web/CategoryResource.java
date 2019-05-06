package com.targa.labs.product.web;

import com.targa.labs.commons.utils.Web;
import com.targa.labs.product.service.CategoryService;
import com.targa.labs.commons.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/categories")
public class CategoryResource {

    private final CategoryService categoryService;
    @GetMapping
    public List<CategoryDto> findAll() {
        return this.categoryService.findAll();
    }
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return this.categoryService.findById(id);
    }
    @PostMapping
    public CategoryDto create(CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.delete(id);
    }
}
