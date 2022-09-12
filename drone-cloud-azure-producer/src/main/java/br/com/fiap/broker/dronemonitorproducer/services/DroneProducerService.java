package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorproducer.vo.NotPermitionException;

public interface DroneProducerService {

    void registerDrone(final String droneId, final DroneVO drone) throws NullPointerException, NotPermitionException;
}
