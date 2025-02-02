package it.univr.instructions;

import java.util.List;

public class REPEAT implements Instruction {

    private final int rep;
    private final Instruction inst;

    public REPEAT(int rep, Instruction inst) {
        this.rep = rep;
        this.inst = inst;
    }

    public void execute(List<Integer> stack) throws IllegalProgramException {
        for(int i = 0; i < rep; i++) {
            inst.execute(stack);
        }
    }

    public String toString() {
        return "repeat(" + rep + ", " + inst + ")";
    }
}
