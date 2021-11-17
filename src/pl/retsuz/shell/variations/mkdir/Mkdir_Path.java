package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_Path extends CommandVariation {
    public Mkdir_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        Composite currentElem = (Composite) this.getParent().getContext().getCurrent();

        String[] subParams;
        subParams = params.split("/");
        IComposite temElem = null;

        int index = 0;



        if (subParams.length - 1 >= index) {
            for (int i = index; i <= subParams.length - 1; i++) {
                try {
                    temElem = createNewElem(currentElem, subParams[i]);
                    currentElem = (Composite) temElem;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.createNewElem(currentElem, subParams[index]);
        }
    }

    private Composite createNewElem(Composite current, String name) {
        Composite newElem = new Composite();

        try {
            newElem.setName(name);
            newElem.setParent(current);
            current.addElement(newElem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newElem;
    }
}
