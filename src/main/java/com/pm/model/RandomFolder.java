package com.pm.model;

import java.util.Objects;

public class RandomFolder implements Folder {
    private final String name;
    private final String size;

    public RandomFolder(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RandomFolder that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "RandomFolder{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
