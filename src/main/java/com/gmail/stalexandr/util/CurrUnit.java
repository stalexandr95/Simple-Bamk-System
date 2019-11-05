package com.gmail.stalexandr.util;

public enum CurrUnit {
    USD, EUR, UAH, RUB;

    @Override
    public String toString() {
        return name();
    }
}
