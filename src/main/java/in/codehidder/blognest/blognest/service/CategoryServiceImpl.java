package in.codehidder.blognest.blognest.service;

import in.codehidder.blognest.blognest.dto.CategoryRequestDto;
import in.codehidder.blognest.blognest.dto.CategoryResponseDto;
import in.codehidder.blognest.blognest.entity.Category;
import in.codehidder.blognest.blognest.exception.ResourceNotFoundException;
import in.codehidder.blognest.blognest.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto requestDto) {
        Category category = modelMapper.map(requestDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryResponseDto.class);
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponseDto.class))
                .toList();
    }

    @Override
    public CategoryResponseDto updateCategoryById(Long id, CategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found"));

        modelMapper.map(requestDto, category);
        return modelMapper.map(category, CategoryResponseDto.class);
    }

    @Override
    public void deleteCategoryById(Long id) {
        boolean exists = categoryRepository.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("Category with id: " + id + " not found");
        }

        categoryRepository.deleteById(id);
    }
}
