package com.rminaya.mapstructlombokdemo.mapper;

import com.rminaya.mapstructlombokdemo.dto.GetCategory;
import com.rminaya.mapstructlombokdemo.entity.Category;
import com.rminaya.mapstructlombokdemo.repository.CategoryRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    // En caso los atributos tengan el mismo nombre tipo no será necesario anotar con "@Mappings" ni "@Mapping"
    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "name", target = "categoryName"),
    })
    abstract GetCategory toGetCategory(Category category);

    // Mapeo automático sin necesitar buscar algún atributo en la BD
    /*
    @InheritInverseConfiguration
    Category toEntity(GetCategory getCategory);
    */

    // Mapeo personalizado al necesitar buscar algún atributo en la BD
    Category toEntity(GetCategory getCategory) {
        // Validación del argumento
        if (getCategory == null) return null;
        // Búsqueda del ENTITY en la BD.
        Category category = this.categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if (category == null) return null;
        // Asignamos al ENTITY solo los atributos recibidos del DTO
        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());

        return category;

    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);

    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);
}
