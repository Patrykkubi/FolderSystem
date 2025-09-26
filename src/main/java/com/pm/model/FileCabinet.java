package com.pm.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = (folders != null) ? new ArrayList<>(folders) : new ArrayList<>();
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return flatten(folders)
                .filter(f -> f.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        return flatten(folders)
                .filter(f -> f.getSize().equals(size))
                .toList();
    }

    @Override
    public int count() {
        return (int) flatten(folders).count();
    }

    // Flattens the list of folders
    private Stream<Folder> flatten(List<Folder> folders) {
        return folders.stream().flatMap(f ->
                (f instanceof MultiFolder mf)
                        ? Stream.concat(Stream.of(f), flatten(mf.getFolders()))
                        : Stream.of(f)
        );
    }
}
