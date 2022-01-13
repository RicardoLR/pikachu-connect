package com.rich.client.converter

abstract class PokemonConverter <E,D> {
    abstract D fromMap(HashMap body);
}