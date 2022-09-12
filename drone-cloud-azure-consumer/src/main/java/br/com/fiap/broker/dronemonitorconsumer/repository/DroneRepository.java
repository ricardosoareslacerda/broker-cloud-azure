package br.com.fiap.broker.dronemonitorconsumer.repository;

import br.com.fiap.broker.dronemonitorconsumer.model.Drone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends MongoRepository<Drone, String> {
}