package battleship.services;

import battleship.models.CategoryModel;
import battleship.models.entities.Category;
import battleship.models.enums.ShipCategory;
import battleship.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct(){
        if (this.categoryRepository.count() == 0) {
            this.categoryRepository.saveAllAndFlush(Arrays.stream(ShipCategory.values())
                    .map(enumValue -> CategoryModel.builder()
                            .name(enumValue)
                            .description(enumValue + " description...")
                            .build())
                    .map(categoryModel -> this.modelMapper.map(categoryModel, Category.class))
                    .toList());
        }
    }
}
