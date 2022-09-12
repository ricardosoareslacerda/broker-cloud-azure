package br.com.fiap.broker.dronemonitorconsumer.service;

import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;

public interface DroneService {

    void persist(final DroneVO droneVO);
}
