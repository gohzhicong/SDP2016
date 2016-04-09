/*package sml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.reflect.*;

/**
 * Created by gohzh on 09/04/2016.

public class TestReflect {
    public static void main (String[] args) throws ClassNotFoundException {
   //need to know which class it is
        //need to then know what parameters need to be passed
        //modify the parameters
        String ins= "sml.Bnz";
        String className = ins+"Instruction";
        Class instr = null;
        instr = Class.forName(className);

        //System.out.println(instr.getName());
/*
        Field[] requiredFields = instr.getDeclaredFields();
        for(int i=0;i<requiredFields.length;++i) {
            System.out.println(requiredFields[i].getName());
            if(requiredFields[i].getClass().equals(int.class)){
                try {
                    requiredFields[i].set(instr, 3);//to be replaced by scanint
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }else if(requiredFields[i].getClass().equals(String.class)){
                try {
                    requiredFields[i].set(instr, "hi");//to be replaced by scan
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


        }


    }*/
