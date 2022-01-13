package com.rich.client.service

import com.rich.client.exception.PokemonApiException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import javax.ws.rs.WebApplicationException
import javax.ws.rs.client.Invocation
import javax.ws.rs.client.ResponseProcessingException
import javax.ws.rs.client.WebTarget
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Service
class PokemonClientImpl implements PokemonClient {

    @Autowired @Qualifier("pokemonWebTarget") WebTarget webTarget;

    @Override
    HashMap getPokemon(String name) {
        try {
            Response response = this.getInvocationBuilder("/"+name).get()
            if(response.getStatus() != 200) {
                throw new PokemonApiException("Failure name "+name +", status" + response.getStatus())
            }
            return response.readEntity(HashMap.class);
        } catch (ResponseProcessingException | WebApplicationException e) {
            throw new PokemonApiException("Failure name "+name +", message" + e.getMessage())
        }
    }

    protected Invocation.Builder getInvocationBuilder(String complete) {
        return webTarget
                .path(complete)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON);
    }
}
