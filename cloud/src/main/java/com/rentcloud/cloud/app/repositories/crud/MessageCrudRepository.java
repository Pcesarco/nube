/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentcloud.cloud.app.repositories.crud;

import com.rentcloud.cloud.app.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Administrador
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    
}
