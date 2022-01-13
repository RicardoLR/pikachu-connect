package com.rich.client.service

import com.rich.client.dto.PokemonDTO

interface PokemonClient {
    HashMap getPokemon(String name)
}
