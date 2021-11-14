package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv extends Command {
    public Mv(IContext ctx, ICommand next) {
        super("mv *([a-zA-Z0-9.l\\/_]*)", ctx, next, null, "Użycie mv <sciezka1> <sciezka2>");
    }
}
