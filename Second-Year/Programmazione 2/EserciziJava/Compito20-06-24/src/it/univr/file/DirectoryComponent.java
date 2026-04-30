package it.univr.file;

import java.io.FileNotFoundException;
import java.util.*;

public class DirectoryComponent extends AbstractComponent {
    // aggiungete campi, se servissero
    private final List<Component> children = new ArrayList<>();

    /**
     * Costruisce una componente di tipo directory con il nome indicato
     * e le sottocomponenti (figli) indicate.
     */
    public DirectoryComponent(String name, Component... children) {
        super(name);
        // Ordiniamo i figli per nome
        Arrays.sort(children, Comparator.comparing(Component::getName));
        this.children.addAll(Arrays.asList(children));
    }

    @Override
    public String toString(String nesting) {
        String result = nesting + getName() + "/";

        for (Component child: children)
            result += "\n" + child.toString(nesting + "\t");

        return result;
    }

    @Override
    public int size() {
        int res = 100;

        for (Component child : children) {
            res += child.size();
        }

        return res;
    }

    @Override
    public List<FileComponent> getFiles() {
        List<FileComponent> res = new ArrayList<>();

        for (Component child : children) {
            res.addAll(child.getFiles());
        }

        return res;
    }

    @Override
    public String find(String name) throws FileNotFoundException {
        for(Component child : children) {
            try {
                return getName() + "/" + child.find(name);
            } catch (FileNotFoundException e) {

            }
        }

        throw new FileNotFoundException(name);
    }


    // implementate sotto i metodi public ancora astratti
}