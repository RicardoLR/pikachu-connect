package com.rich.client.config

import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Configuration
class PokemonClientConfig {

    @Value('${pokemon.app.host}')
    private String host

    @Value('${pokemon.app.path}')
    private String path

    @Bean
    @Qualifier("pokemonWebTarget")
    WebTarget pokemonWebTarget() {
        ClientBuilder.newClient()
                .register(JacksonFeature.class)
                .target(this.getFullUrl())
    }

    private String getFullUrl() {
        return new StringBuilder()
                .append(this.host)
                .append(this.path)
                .toString();
    }

}
