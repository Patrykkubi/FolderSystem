package com.pm;

import com.pm.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // I assume that the folders would have unique names,
        // however I wanted to show that program works with duplicates as well

        //dymmy test data
        Folder folder1 = new RandomFolder("Folder1", "SMALL");
        Folder folder2 = new RandomFolder("Folder2", "MEDIUM");
        Folder folder3 = new RandomFolder("Folder3", "LARGE");

        List<Folder> folders = new ArrayList<>(Arrays.asList(folder1, folder2, folder3));

        //creating multiFolders containing multiFolders...
        MultiFolder multiFolder1 = new RandomMultiFolder("MultiFolder1", "MEDIUM", folders);
        folders.add(multiFolder1);
        MultiFolder multiFolder2 = new RandomMultiFolder("MultiFolder2", "LARGE", folders);
        folders.add(multiFolder2);
        MultiFolder multiFolder3 = new RandomMultiFolder("MultiFolder3", "MEDIUM", folders);
        folders.add(multiFolder3);

        FileCabinet fileCabinet = new FileCabinet(folders);

        System.out.println(fileCabinet.count());
        System.out.println(fileCabinet.findFolderByName("MultiFolder1"));
        System.out.println(fileCabinet.findFoldersBySize("LARGE"));
    }
}


