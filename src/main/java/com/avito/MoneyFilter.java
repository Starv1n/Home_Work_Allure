package com.avito;

public enum MoneyFilter {
    По_умолчанию("101"),
    Дороже("2"),
    Дешевле("1"),
    По_дате("104");

    public final String value;

    MoneyFilter(String value) {
        this.value = value;
    }
}
