package com.coderpwh.cargo.common.util.mapstruct;

public abstract class MapStructDecorator<D, E> implements MapStructConverter<D, E> {
    public MapStructConverter mapStructConverter;

    public MapStructDecorator(MapStructConverter mapStructConverter) {
        this.mapStructConverter = mapStructConverter;
    }
}
