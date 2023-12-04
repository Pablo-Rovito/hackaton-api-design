package com.hackathon.equipo2.CineHackacthon.validators;

import org.springframework.cglib.core.internal.Function;

public class AbstractValidator<K, V> implements Function<K, V> {


    @Override
    public V apply(K key) {
        return null;
    }
}
