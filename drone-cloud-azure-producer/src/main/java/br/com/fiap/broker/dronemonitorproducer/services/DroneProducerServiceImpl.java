package br.com.fiap.broker.dronemonitorproducer.services;

import br.com.fiap.broker.dronemonitorproducer.business.DroneBusiness;
import br.com.fiap.broker.dronemonitorproducer.parser.JsonCustomParser;
import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorproducer.vo.NotPermitionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DroneProducerServiceImpl implements DroneProducerService {

    private final DroneBusiness droneBusiness;

    @Value("${topic.name.producer}")
    private String topic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void registerDrone(final String droneId, final DroneVO droneVO) throws NullPointerException, NotPermitionException {

        log.info("Validate Data Object: Drone: {}", droneVO);
        droneBusiness.validateRulesToPublish(droneId, droneVO);

        log.info("Fill Data Object: Drone: {}", droneVO);
        droneBusiness.fillDataToPublish(droneId, droneVO);

        try {
            log.info("Sending drone to kafka: {}", droneVO);
            kafkaTemplate.send(topic, droneVO);
        }
        catch (Exception e) {
            log.error("Error sending drone to kafka: {}", droneVO, e);
        }

        log.info("Producer Drone: {} ", JsonCustomParser.parseObjectToJson(DroneVO.class, droneVO));
    }
}
