package br.com.fiap.broker.dronemonitorproducer.rest;

import br.com.fiap.broker.dronemonitorproducer.services.DroneProducerService;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorproducer.vo.NotPermitionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ControllerApiImpl implements Api {

    private final DroneProducerService droneProducerService;

    @Override
    public void registerDrone(@PathVariable final String droneId, @RequestBody final DroneVO drone) throws NullPointerException, NotPermitionException {
        log.info("Registering drone with id {}", droneId);
        this.droneProducerService.registerDrone(droneId, drone);
    }
}
