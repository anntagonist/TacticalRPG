package com.gdt.interfaces;

public interface Requireable<T> {
    boolean isRequired(T handler);
}
