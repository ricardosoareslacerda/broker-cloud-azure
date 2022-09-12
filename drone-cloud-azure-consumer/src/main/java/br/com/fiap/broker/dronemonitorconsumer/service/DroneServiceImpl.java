package br.com.fiap.broker.dronemonitorconsumer.service;

import br.com.fiap.broker.dronemonitorconsumer.model.Drone;
import br.com.fiap.broker.dronemonitorconsumer.repository.DroneRepository;
import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    @Autowired
    private final DroneRepository droneRepository;

    @Override
    public void persist(final DroneVO droneVO) {

        final Drone drone = Drone.builder().id(droneVO.getId()).name(droneVO.getName()).latitude(droneVO.getLatitude())
                .longitude(droneVO.getLongitude()).
                temperature(droneVO.getTemperature()).
                humidity(droneVO.getHumidity()).
                rastreability(true).
                lastUpdate(droneVO.getLastUpdate()).
                build();
        droneRepository.save(drone);
        log.warn("Drone " + droneVO.getId() + " is persisted | Hour: " + new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").getInstance().format(droneVO.getLastUpdate()));
    }
}