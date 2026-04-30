package it.univr.instructions;

import java.util.List;

public class MULT implements Instruction {

    public MULT() {}

    public void execute(List<Integer> stack) throws IllegalArgumentException {
        if(stack.size() < 2)
            throw new IllegalProgramException("Operandi insufficienti per un operazione binaria");

        int n1 = stack.removeLast();
        int n2 = stack.removeLast();

        stack.add(n2 * n1);
    }

    public String toString(){
        return "mult";
    }
}
