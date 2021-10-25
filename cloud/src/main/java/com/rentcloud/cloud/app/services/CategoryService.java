/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Category;
import com.rentcloud.cloud.app.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Categoryistrador
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    /**
     * GET
     *
     * @return Lista de category.
     */
    public List<Category> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param categoryId
     * @return
     */
    public Optional<Category> getCategory(int categoryId) {
        return repository.getCategory(categoryId);
    }

    /**
     * POST
     *
     * @param category
     * @return
     */

    public Category save(Category category) {
        //Consultar si se envía el ID
        if (category.getId() == null) {
            return repository.save(category);
        } else {
            //Consultar si existe el registro.
            Optional<Category> existCategory = repository.getCategory(category.getId());
            if (existCategory.isPresent()) {
                return category;
            } else {
                return repository.save(category);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param category
     * @return
     */

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> existCategory = repository.getCategory(category.getId());
            if (existCategory.isPresent()) {
                if (category.getName() != null) {
                    existCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    existCategory.get().setDescription(category.getDescription());
                }
                if(category.getClouds()!=null){
                    existCategory.get().setClouds(category.getClouds());
                }
                return repository.save(existCategory.get());
            } else {
                return category;
            }
        } else {
            return category;
        }
    }
/**
 * DELETE
 * @param categoryId
 * @return 
 */
    public boolean delete(int categoryId) {
        Boolean respuesta = getCategory(categoryId).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
