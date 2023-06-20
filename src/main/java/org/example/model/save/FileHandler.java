package org.example.model.save;

import org.example.model.familyTree.FamilyTree;
import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(FamilyTree tree, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(tree);
        out.close();
    }
    @Override
    public FamilyTree read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree tree =  (FamilyTree)in.readObject();
        in.close();
        return tree;
    }
}
