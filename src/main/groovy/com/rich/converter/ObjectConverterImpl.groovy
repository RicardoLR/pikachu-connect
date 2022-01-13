package com.rich.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.rich.exception.TypeConverterException
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class ObjectConverterImpl extends ObjectConverter<Object, String> {

    private ObjectMapper mapper = new ObjectMapper()

    @Override
    String fromObject(Object object) {
        if(object == null) return null
        try {
            return mapper.writeValueAsString(object)
        }
        catch (JsonProcessingException e) {
            log.error "Error serializing body, ${e.getMessage()}"
            throw new TypeConverterException(object.toString())
        }
    }
}
