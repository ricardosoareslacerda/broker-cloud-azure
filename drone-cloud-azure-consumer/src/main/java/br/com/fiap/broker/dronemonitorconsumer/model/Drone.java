    package br.com.fiap.broker.dronemonitorconsumer.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Document(collection = "drones")
public class Drone {

    @MongoId(FieldType.STRING)
    @Field("id")
    @EqualsAndHashCode.Include
    private String id;

    @Field("name")
    private String name;

    @Field("latitude")
    private BigDecimal latitude;

    @Field("longitude")
    private BigDecimal longitude;

    @Field("temperature")
    private long temperature;

    @Field("humidity")
    private long humidity;

    @Field("rastreability")
    private boolean rastreability;

    @Field("lastUpdate")
    private Date lastUpdate;

    @Field("requestClientJob")
    private boolean requestClientJob;
}