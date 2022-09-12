package br.com.fiap.broker.dronemonitorconsumer.consumer;

import br.com.fiap.broker.dronemonitorconsumer.business.DroneBusiness;
import br.com.fiap.broker.dronemonitorconsumer.parser.JsonCustomParser;
import br.com.fiap.broker.dronemonitorconsumer.vo.DroneVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroneConsumer {

    private final DroneBusiness droneBusiness;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${group.name.consumer}", containerFactory = "jsonKafkaListenerContainerFactory")
    public void consume(@Payload DroneVO payload, @Headers MessageHeaders headers) {

        headers.keySet().forEach(key -> {
            log.info("{}: {}", key, headers.get(key));
        });

        log.info("Consumer Drone: {} ", JsonCustomParser.parseObjectToJson(DroneVO.class, payload));
        droneBusiness.verifyDrone(payload);
    }
}