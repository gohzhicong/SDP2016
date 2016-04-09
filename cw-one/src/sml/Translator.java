package sml;

import jdk.nashorn.internal.objects.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.reflect.*;
/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String PATH = "/Users/gohzh/ideaprojects/sdp2016/";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    public Translator(String fileName) {
        this.fileName = PATH + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = null;
                    try {
                        ins = getInstruction(label);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            System.exit(-1);
            return false;
        }
        return true;
    }

    // line should consist of an MML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        int x;
        String L2;

        if (line.equals(""))
            return null;

        String ins = scan();
        /*
        switch (ins) {
            case "add":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new AddInstruction(label, r, s1, s2);
            case "sub":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new SubInstruction(label, r, s1, s2);
            case "mul":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new MulInstuction(label, r, s1, s2);
            case "div":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new DivInstruction(label, r, s1, s2);
            case "lin":
                r = scanInt();
                s1 = scanInt();
                return new LinInstruction(label, r, s1);
            case "out":
                r = scanInt();
                return new OutInstruction(label, r);
            case "bnz":
                s1 = scanInt();
                L2 = scan();
//                return new BnzInstruction(label, s1, L2);
        }
*/
        // new code should come here
        //need to know which class it is
        String ins2= "sml.";
        String ins3 = ins.substring(0, 1).toUpperCase() + ins.substring(1);
        String className = ins2+ins3+"Instruction";

        Class instr = Class.forName(className);

        //need to then know what parameters need to be passed
        Constructor[] constructors = instr.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < constructors.length; i++) {
            ctor = constructors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        //initialise the class
        Instruction output = null;
        try {
            if (ctor != null) {
                Type[] genericParameters =ctor.getGenericParameterTypes();
                Object[] values = new Object[genericParameters.length];
                for(int i=0;i<genericParameters.length;++i){
                    if(genericParameters[i]==int.class )
                        values[i]=0;//arbitrary
                    else if(genericParameters[i]==String.class)
                        values[i]=label;//arbitrary
                }

                output = (Instruction) ctor.newInstance(values);
            }
        } catch (InvocationTargetException e) {
             e.printStackTrace();
        }
        //modify the parameters
        Field[] requiredFields = instr.getDeclaredFields();
        for(int i=0;i<requiredFields.length;++i) {

            Class requiredFieldClass = requiredFields[i].getType();

            if(requiredFieldClass.equals(int.class)){
                try {
                    requiredFields[i].setAccessible(true);
                    requiredFields[i].set(output, scanInt());//to be replaced by scanint
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(requiredFieldClass.equals(String.class)){
                try {
                    requiredFields[i].setAccessible(true);
                    requiredFields[i].set(output, scan());//to be replaced by scan
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return output;
    }

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}