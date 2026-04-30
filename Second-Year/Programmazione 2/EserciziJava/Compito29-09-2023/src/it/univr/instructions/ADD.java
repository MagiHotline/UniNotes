package it.univr.instructions;

import java.util.List;

public class ADD implements Instruction {

    public ADD() {}

    public void execute(List<Integer> stack) throws IllegalProgramException {

        if(stack.size() < 2)
            throw new IllegalProgramException("Operandi insufficienti per un operazione binaria");

        int n1 = stack.removeLast();
        int n2 = stack.removeLast();

        stack.add(n2 + n1);
    }

    public String toString(){
        return "add";
    }


}
