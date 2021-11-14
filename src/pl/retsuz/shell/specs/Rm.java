package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Rm extends Command {
    public Rm(IContext ctx, ICommand next) {
        super("rm", ctx, next, null, "Użycie rm <sciezka>");
    }
}
