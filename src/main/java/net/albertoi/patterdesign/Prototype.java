package net.albertoi.patterdesign;

public interface Prototype<T extends Prototype> extends Cloneable {
    T clone();

    T deepClone();
}
