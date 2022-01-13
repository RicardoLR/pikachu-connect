#!/bin/bash

HOST_WSDL='http://localhost:8081/api/v1/pokemon/ws/pokemon.wsdl'
POKEMON_NAME='ditto'


GET_RESPONSE_1=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>abilities</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_1}" 

GET_RESPONSE_2=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>baseExperience</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_2}" 


GET_RESPONSE_3=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>id</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_3}" 

GET_RESPONSE_4=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>heldItems</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_4}" 

GET_RESPONSE_5=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>locationAreaEncounters</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_5}" 

GET_RESPONSE_ALL=$(curl --location --request POST "$HOST_WSDL" \
    --header 'Content-Type: text/xml' \
    --header 'X-FORWARDED-FOR: 201.142.129.25' \
    --data-raw "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/'
        xmlns:gs='http://spring.io/guides/gs-producing-web-service'>
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getPokemonRequest>
            <gs:name>"$POKEMON_NAME"</gs:name>
            <gs:property>all</gs:property>
        </gs:getPokemonRequest>
    </soapenv:Body>
    </soapenv:Envelope>" )
echo "${GET_RESPONSE_ALL}" 

wait
exit 0;