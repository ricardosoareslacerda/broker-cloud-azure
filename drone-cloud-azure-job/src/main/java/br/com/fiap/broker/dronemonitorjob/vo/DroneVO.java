package br.com.fiap.broker.dronemonitorjob.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DroneVO {

    private String id;

    private String name;

    private Float latitude;

    private Float longitude;

    private long temperature;

    private long humidity;

    private boolean rastreability;

    private String lastUpdate;

    private boolean requestClientJob;
}