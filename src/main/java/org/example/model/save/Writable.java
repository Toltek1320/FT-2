package org.example.model.save;

import org.example.model.familyTree.FamilyTree;

import java.io.IOException;

public interface Writable {
    void save(FamilyTree tree, String fileAddress) throws IOException;
    FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException;
}
