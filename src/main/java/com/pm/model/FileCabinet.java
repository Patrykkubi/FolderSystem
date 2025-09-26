package com.pm.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    public FileCabinet(List<Folder> folders) {
        this.folders = (folders != null) ? new ArrayList<>(folders) : new ArrayList<>();
    }

    // I assume that folders should have unique names since we want
    // the return of this method to be Optional of a single folder
    // but it works with duplicates as well
    // it will just return first folder with the given name found
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
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) flatten(folders).count();
    }

    // Flattens the list of folders including multiFolders into a stream of single folders
    // Since the multiFolder is also in itself a folder,
    // then List containing a multiFolder of 3 folders will result in count = 4
    private Stream<Folder> flatten(List<Folder> folders) {
        return folders.stream()
                .flatMap(f -> {
                    if (f instanceof MultiFolder) {
                        return Stream.concat(
                                Stream.of(f),
                                flatten(((MultiFolder) f).getFolders())
                        );
                    } else {
                        return Stream.of(f);
                    }
                });
    }
}
