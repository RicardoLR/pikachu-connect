package com.rich.converter

abstract class ObjectConverter <Object, String> {
    abstract String fromObject(Object body)
}