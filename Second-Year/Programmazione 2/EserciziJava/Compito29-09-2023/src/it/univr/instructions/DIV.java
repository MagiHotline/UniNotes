package it.univr.instructions;

import java.util.List;

public class DIV implements Instruction {

    public DIV () {
    }

    public void execute(List<Integer> stack) throws IllegalProgramException {
        if(stack.size() < 2)
            throw new IllegalProgramException("Operandi insufficienti per un operazione binaria");

        if (stack.getLast() == 0)
            throw new IllegalProgramException("Divisione per zero");

        int dividendo = stack.removeLast();
        int divisore = stack.removeLast();

        stack.add(divisore / dividendo);
    }

    public String toString(){
        return "div";
    }
}
