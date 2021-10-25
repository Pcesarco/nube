/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Cloud;
import com.rentcloud.cloud.app.repositories.crud.CloudCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cloudistrador
 */
@Repository
public class CloudRepository {
    @Autowired
    private CloudCrudRepository repository;
    
    
    /**
     * SELECT*FROM
     * @return retorna todos los registros de la tabla
     */
    public List<Cloud> getAll(){
        return (List<Cloud>) repository.findAll();
    }
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID

     */
    public Optional<Cloud> getCloud(int id){
        return repository.findById(id);
    }
    /**
     * INSERT & UPDATE
     * @param cloud
     * @return Cloud Actualiza registro ya existente o Crea un nuevo registro

     */
    public Cloud save(Cloud cloud){
        return repository.save(cloud);
    }
    /**
     * DELETE FROM TABLE
     * @param cloud 
     */
    public void delete (Cloud cloud){
        repository.delete(cloud);
    }
}
