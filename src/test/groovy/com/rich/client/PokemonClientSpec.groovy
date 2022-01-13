package com.rich.client

import com.rich.client.config.PokemonClientConfig
import com.rich.client.exception.PokemonApiException
import com.rich.client.service.PokemonClient
import com.rich.client.service.PokemonClientImpl
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.mockserver.client.server.MockServerClient
import org.mockserver.integration.ClientAndServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.ClassPathResource
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.WebApplicationException
import javax.ws.rs.client.WebTarget

import static org.mockserver.integration.ClientAndServer.startClientAndServer
import static org.mockserver.matchers.Times.exactly
import static org.mockserver.model.HttpRequest.request
import static org.mockserver.model.HttpResponse.response

@ContextConfiguration(classes = [PokemonClientConfig])
@TestPropertySource(locations = ["classpath:application-test.properties"])
class PokemonClientSpec extends Specification {

    @Shared
    private ClientAndServer mockServer

    def setupSpec() {
        mockServer = startClientAndServer(10038)
    }

    def cleanupSpec() {
        mockServer.stop()
    }

    @Autowired
    @Qualifier("pokemonWebTarget")
    WebTarget pokemonWebTarget

    def "Should set up a mock server and Get data from pokemon API"() {
        setup:
        File fileMock = new ClassPathResource("pokemon.200.json").getFile()
        def mock = new JsonSlurper().parse(fileMock)
        PokemonClient serviceClient = new PokemonClientImpl()
        serviceClient.webTarget = pokemonWebTarget
        new MockServerClient("127.0.0.1", 10038)
                .when(request()
                        .withMethod("GET")
                        .withPath("/api/v2/pokemon/pikachu"),
                        exactly(1)
                ).respond(
                response()
                        .withStatusCode(200)
                        .withHeader("Content-Type", "application/json;charset=UTF-8")
                        .withBody("""${JsonOutput.toJson(mock)}""")
        )
        when:
        HashMap<String, Object> map = serviceClient.getPokemon('pikachu')
        then:
        map.get('id') == 25
        map.get('abilities')
        map.get('location_area_encounters') == "https://pokeapi.co/api/v2/pokemon/25/encounters"
    }

    def "Should throw WebApplicationException"() {
        given:
        PokemonClientImpl thing = Spy(PokemonClientImpl)
        thing.webTarget = Mock(WebTarget)
        thing.getInvocationBuilder(_) >> { throw new WebApplicationException() }
        when:
        thing.getPokemon('something')
        then:
        final PokemonApiException ex = thrown()
        ex.getMessage() == 'Failure name something, messageHTTP 500 Internal Server Error'
    }

}
