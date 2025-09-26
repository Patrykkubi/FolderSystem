package com.pm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RandomMultiFolder implements MultiFolder {

    private final String name;
    private final String size;
    private final List<Folder> folders;

    public RandomMultiFolder(String name, String size, List<Folder> folders) {
        this.name = name;
        this.size = size;
        this.folders = new ArrayList<>(folders);
    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public List<Folder> getFolders() {
        return this.folders;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RandomMultiFolder that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(size, that.size) && Objects.equals(folders, that.folders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, folders);
    }

    @Override
    public String toString() {
        return "RandomMultiFolder{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", folders=" + folders +
                '}';
    }
}
