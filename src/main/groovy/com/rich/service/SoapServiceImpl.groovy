package com.rich.service

import com.rich.client.converter.PokemonConverter
import com.rich.client.dto.PokemonDTO
import com.rich.client.service.PokemonClient
import com.rich.entity.TraceModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SoapServiceImpl implements SoapService {

    @Autowired PokemonClient pokemonClient
    @Autowired PokemonConverter pokemonConverter
    @Autowired TraceModelService traceModelService

    @Override
    PokemonDTO fetchProps(String name, String ip, String method) {
        traceModelService.save(new TraceModel(
                ip: ip,
                date: LocalDateTime.now(),
                method: method
        ))
        pokemonConverter.fromMap(pokemonClient.getPokemon(name))
    }
}
