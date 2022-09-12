package br.com.fiap.broker.dronemonitorconsumer.vo;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class MailVO {

    private String fromAddress;
    private String toAddresses;
    private String ccAddresses;
    private String bccAddresses;
    private String subject;
    private String body;
    private String[] attachments;
    private DroneVO drone;
}