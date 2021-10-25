/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Category;
import com.rentcloud.cloud.app.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Categoryistrador
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository repository;
    
    
    /**
     * SELECT*FROM
     * @return retorna todos los registros de la tabla
     */
    public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID

     */
    public Optional<Category> getCategory(int id){
        return repository.findById(id);
    }
    /**
     * INSERT & UPDATE
     * @param category
     * @return Category Actualiza registro ya existente o Crea un nuevo registro

     */
    public Category save(Category category){
        return repository.save(category);
    }
    /**
     * DELETE FROM TABLE
     * @param category 
     */
    public void delete (Category category){
        repository.delete(category);
    }
}
