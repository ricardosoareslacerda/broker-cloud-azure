package br.com.fiap.broker.dronemonitorproducer.vo;

import lombok.*;
import org.springframework.lang.NonNull;

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

    @NonNull
    private Date lastUpdate;

    private boolean requestClientJob;
}