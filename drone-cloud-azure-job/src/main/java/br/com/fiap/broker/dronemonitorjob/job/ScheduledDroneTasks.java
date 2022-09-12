package br.com.fiap.broker.dronemonitorjob.job;

import br.com.fiap.broker.dronemonitorjob.parser.JsonCustomParser;
import br.com.fiap.broker.dronemonitorjob.vo.DroneVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Slf4j
@Component
public class ScheduledDroneTasks {

    @Value("${drone.api.host.path}")
    private String hostPath;

    @Value("${drone.api.host.resource}")
    private String hostResource;

    @Value("#{${listOfDrones}}")
    private Map<String, String> listOfDrones;

    private RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${dronemonitor.job.cron-scheduler}")
    public void registerDrones() {

        listOfDrones.forEach((droneId, droneName) -> {
            log.info("Registering Drone: {}: {}", droneId, droneName);
            final DroneVO droneVO = this.getDroneVO(droneId, droneName);

            log.info("DroneVO: {}", JsonCustomParser.parseObjectToJson(DroneVO.class, droneVO));
            log.info("The time of register drone {}", new SimpleDateFormat("HH:mm:ss").format(new Date()));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            restTemplate.exchange(hostPath.concat(hostResource).concat(droneVO.getId()), HttpMethod.PUT, new HttpEntity<DroneVO>(droneVO, headers), String.class);
        });
    }

    private DroneVO getDroneVO(final String droneId, final String droneName) {
        DroneVO droneVO = DroneVO.builder().
                                        id(droneId).
                                        name(droneName).
                                        latitude(this.getRandomValuesBetween(-100F, 100F)).
                                        longitude(this.getRandomValuesBetween(-100F, 100F)).
                                        temperature(this.getRandomValuesBetween(-25L, 40L)).
                                        humidity(this.getRandomValuesBetween(0L, 100L)).
                                        rastreability(getRandomValuesBetween()).
                                        lastUpdate(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"))).
                                        requestClientJob(true).
                                        build();
        return droneVO;
    }

    private long getRandomValuesBetween(long min, long max) {
        return (long) ((Math.random() * (max - min)) + min);
    }

    private float getRandomValuesBetween(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }

    private boolean getRandomValuesBetween() {
        return new Random().nextBoolean();
    }
}
