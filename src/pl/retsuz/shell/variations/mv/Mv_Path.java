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
        super(next,parent,"([a-zA-Z0-9.l\\/_]*) *([a-zA-Z0-9.l\\/_]*)");
    }

    @Override
    public void make(String params)
    {
        String[] paramsArr = params.split(" ");
        System.out.println(params);
        System.out.println(paramsArr[1]);

        try {
            Composite currentPath = (Composite) this.getParent().getContext().getCurrent();
            Composite src = (Composite) currentPath.findElementByPath(paramsArr[0]);
            Composite dst = (Composite) currentPath.findElementByPath(paramsArr[1]);
            ((Composite) src.getParent()).removeElement(src);
            src.setParent(dst);
            dst.addElement(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}