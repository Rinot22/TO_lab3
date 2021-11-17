package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Rm_Path extends CommandVariation {
    public Rm_Path(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        String path = params.substring(0, params.lastIndexOf("/"));
        String name = params.substring(params.lastIndexOf("/") + 1);


        try {
            IComposite elem = c.findElementByPath(path);
            Composite elementToRemove = new Composite();
            elementToRemove.setName(name);
            ((Composite) elem).removeElement(elementToRemove);
            System.out.printf("Plik/katalog %s zostal usuniety.\n", name);
        } catch (Exception e) {
            System.out.println("Nie udalo sie usunac pliku/katalogu.");
        }
    }
}
