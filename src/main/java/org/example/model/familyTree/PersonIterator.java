package org.example.model.familyTree;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    private final List<E> tree;

    public PersonIterator(List<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public E next() {
        return tree.get(index++);
    }
}
