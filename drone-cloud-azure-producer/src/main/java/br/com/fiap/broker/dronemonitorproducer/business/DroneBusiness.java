package br.com.fiap.broker.dronemonitorproducer.business;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorproducer.vo.NotPermitionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class DroneBusiness {

    public void validateRulesToPublish(final String droneId, final DroneVO droneVO) throws NullPointerException, NotPermitionException {

        this.validateNonNullFields(droneId, droneVO);

        this.isNotPermitionToSendDrone(droneVO);
    }

    private void validateNonNullFields(final String droneId, final DroneVO droneVO) throws NullPointerException {
        if (Objects.isNull(droneVO.getId())
                || StringUtils.isBlank(droneId)) {
            log.error("Drone {} is null drone id!", droneVO);

            if (!droneVO.isRequestClientJob())
                new NullPointerException(MessageFormat.format("Drone {} is null last update!", droneVO));
        }

        if (Objects.isNull(droneVO.getLastUpdate())) {
            log.error("Drone {} is null last update!", droneVO);

            if (!droneVO.isRequestClientJob())
                new NullPointerException(MessageFormat.format("Drone {} is null last update!", droneVO));
        }
    }

    private void isNotPermitionToSendDrone(final DroneVO droneVO) throws NotPermitionException {
        if (!droneVO.isRastreability()) {
            log.error("Drone {} is not rastreability!", droneVO);

            if (!droneVO.isRequestClientJob())
                new NotPermitionException(MessageFormat.format("Drone {} is not rastreability!", droneVO));
        }
    }

    public void fillDataToPublish(final String droneId, final DroneVO droneVO) throws NullPointerException {

        this.fillData(droneId, droneVO);
    }

    private void fillData(final String droneId, final DroneVO droneVO) throws NullPointerException {
        droneVO.setId(droneId);

        droneVO.setLastUpdate(new Date());
    }
}
