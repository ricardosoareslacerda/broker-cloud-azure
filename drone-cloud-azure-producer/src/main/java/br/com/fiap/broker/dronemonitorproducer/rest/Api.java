package br.com.fiap.broker.dronemonitorproducer.rest;

import br.com.fiap.broker.dronemonitorproducer.vo.DroneVO;
import br.com.fiap.broker.dronemonitorproducer.vo.NotPermitionException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(value = "/drones")
public interface Api {

    @Operation(summary = "Registra dados do Drone", description = "Registra os dados de Temperatura, Longitude e Altitude de um Dronoee", tags={ "drone-monitor" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Registro enviado ao broker!"),
            @ApiResponse(responseCode = "400", description = "Recurso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "401", description = "Recurso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "500", description = "Recurso não encontrado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @PutMapping(value = "register/{droneId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    void registerDrone(final String droneId, final DroneVO drone) throws NullPointerException, NotPermitionException;
}
