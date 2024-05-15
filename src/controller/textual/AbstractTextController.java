package controller.textual;

import visual.textual.TextPrinter;

public abstract class AbstractTextController {

    TextPrinter tp;

    abstract void update_printer();

    public void update_and_display(){
        this.update_printer();
        tp.display_on_out();
    }

    public TextPrinter getTextPrinter(){
        return this.tp;
    }
}
