package com.rich.converter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.rich.exception.TypeConverterException
import spock.lang.Specification

class ConvertersSpec extends Specification {

    void "should test ObjectConverterImpl"() {
        setup:
        ObjectConverter converter = new ObjectConverterImpl()
        Map map = [foo: 'bar']
        expect:
        converter.fromObject(map) == "{\"foo\":\"bar\"}"
    }

    void "should catch TypeConverterException exception"() {
        setup:
        ObjectConverter converter = new ObjectConverterImpl()
        converter.mapper = Mock(ObjectMapper)
        def test = [:]
        when:
        converter.fromObject(test)
        then:
        1 * converter.mapper.writeValueAsString(_) >> { throw new JsonProcessingException("test") }
        thrown(TypeConverterException)
    }

}
