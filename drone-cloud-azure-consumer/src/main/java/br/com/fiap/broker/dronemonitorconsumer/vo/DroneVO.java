package br.com.fiap.broker.dronemonitorconsumer.vo;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DroneVO {

    private String id;

    private String name;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private long temperature;

    private long humidity;

    private boolean rastreability;

    private Date lastUpdate;

    private boolean requestClientJob;
}