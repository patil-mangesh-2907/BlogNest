package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.CategoryRequestDto;
import in.codehidder.blognest.blognest.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto requestDto);

    CategoryResponseDto getCategoryById(Long id);

    List<CategoryResponseDto> getAllCategories();

    CategoryResponseDto updateCategoryById(Long id, CategoryRequestDto requestDto);

    void deleteCategoryById(Long id);
}
