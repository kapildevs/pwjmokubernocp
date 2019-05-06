package com.targa.labs.web;

import com.targa.labs.common.Web;
import com.targa.labs.service.ReviewService;
import com.targa.labs.web.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Web.API + "/reviews")
public class ReviewResource {
    private final ReviewService reviewService;
    @GetMapping
    public List<ReviewDto> findAll() {
        return this.reviewService.findAll();
    }
    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable Long id) {
        return this.reviewService.findById(id);
    }
    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return this.reviewService.create(reviewDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }
}