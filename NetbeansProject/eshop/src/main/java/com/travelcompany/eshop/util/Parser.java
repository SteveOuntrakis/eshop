package com.travelcompany.eshop.util;

import java.text.ParseException;

@FunctionalInterface
public interface Parser<T> {
    T parse(String line) throws ParseException;
}
