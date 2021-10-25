/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.Message;
import com.rentcloud.cloud.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Messageistrador
 */
@Repository
public class MessageRepository {
        @Autowired
    private MessageCrudRepository repository;
    
    
    /**
     * SELECT*FROM
     * @return retorna todos los registros de la tabla
     */
    public List<Message> getAll(){
        return (List<Message>) repository.findAll();
    }
    /**
     * SELECT * FROM TABLE WHERE ID=id
     * @param id
     * @return Retorna un registro por el ID

     */
    public Optional<Message> getMessage(int id){
        return repository.findById(id);
    }
    /**
     * INSERT & UPDATE
     * @param message
     * @return Message Actualiza registro ya existente o Crea un nuevo registro

     */
    public Message save(Message message){
        return repository.save(message);
    }
    /**
     * DELETE FROM TABLE
     * @param message 
     */
    public void delete (Message message){
        repository.delete(message);
    }
}
