package com.rich.client.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.rich.client.dto.PokemonDTO
import com.rich.client.exception.PokemonPayloadException
import org.springframework.stereotype.Component

@Component
class PokemonConverterImpl extends PokemonConverter {

    @Override
    PokemonDTO fromMap(HashMap body) {
        try{
            new PokemonDTO(
                    id: body.get('id') as Integer,
                    name: body.get('name') as String,
                    abilities: body.get('abilities') as Map,
                    baseExperience: body.get('base_experience') as Integer,
                    heldItems: body.get('held_items') as Map,
                    locationAreaEncounters: body.get('location_area_encounters') as String
            )
        } catch(UnsupportedOperationException | NullPointerException | IndexOutOfBoundsException | JsonProcessingException ex) {
            throw new PokemonPayloadException("Body: ${body.toString()}")
        }
    }
}
