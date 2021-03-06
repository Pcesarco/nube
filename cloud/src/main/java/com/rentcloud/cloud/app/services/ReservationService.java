/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.Reservation;
import com.rentcloud.cloud.app.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Reservationistrador
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    /**
     * GET
     *
     * @return Lista de reservation.
     */
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    /**
     * GET/{id}
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }

    /**
     * POST
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        //Consultar si se envía el ID
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            //Consultar si existe el registro.
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                return reservation;
            } else {
                return repository.save(reservation);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> existReservation = repository.getReservation(reservation.getIdReservation());
            if (existReservation.isPresent()) {
                if (reservation.getStartDate() != null) {
                    existReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    existReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getClient() != null) {
                    existReservation.get().setClient(reservation.getClient());
                }
                if (reservation.getCloud() != null) {
                    existReservation.get().setCloud(reservation.getCloud());
                }
                if (reservation.getScore() != null) {
                    existReservation.get().setScore(reservation.getScore());
                }
                if (reservation.getStatus() != null) {
                    existReservation.get().setStatus(reservation.getStatus());
                }
                return repository.save(existReservation.get());
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
/**
 * DELETE
 * @param reservationId
 * @return 
 */
    public boolean delete(int reservationId) {
        Boolean respuesta = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
