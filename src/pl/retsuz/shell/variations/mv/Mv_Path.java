package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Path extends CommandVariation
{
    public Mv_Path(ICommandVariation next, ICommand parent)
    {
        super(next,parent,"([a-zA-Z0-9.l\\/_]*\\s[a-zA-Z0-9.l\\/_]*)");
    }

    @Override
    public void make(String params)
    {
        Composite c = (Composite) this.getParent().getContext().getCurrent();
        String[] paramsArr = params.split(" ");

        try {
            IComposite src = c.findElementByPath(paramsArr[0]);
            IComposite src2 = src.getParent();
            IComposite destination = c.findElementByPath(paramsArr[1]);
            Composite.moveElement(src2, destination, src);
            System.out.println("Plik/katalog zostal przeniesiony");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}