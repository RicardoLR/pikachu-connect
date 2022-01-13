package com.rich.endpoint

import com.rich.model.*
import com.rich.service.switches.SwitchService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import javax.servlet.http.HttpServletRequest

@Endpoint
class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private HttpServletRequest requestHttp
    private SwitchService switchService

    @Autowired
    PokemonEndpoint(HttpServletRequest requestHttp, SwitchService switchService) {
        this.requestHttp = requestHttp
        this.switchService = switchService
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    GetPropsResponse selectProperty(@RequestPayload GetPokemonRequest request) {
        switchService.process(
                request.getName(),
                request.getProperty().value(),
                requestHttp.getHeader("X-Forwarded-For")) as GetPropsResponse
    }

}