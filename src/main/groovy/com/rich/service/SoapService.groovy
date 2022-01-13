package com.rich.service

import com.rich.client.dto.PokemonDTO

interface SoapService {
    PokemonDTO fetchProps(String name, String ip, String method)
}
