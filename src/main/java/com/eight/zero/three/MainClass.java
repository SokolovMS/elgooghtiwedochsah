package com.eight.zero.three;

import com.eight.zero.three.algorithm.number2.Algorithm2;
import com.eight.zero.three.file.FileHandler;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

import java.util.function.Function;

/**
 * 2 algorithms
 * 5 files to process
 */
public class MainClass {
    private static final Function<Input, Output> ALGORITHM = Algorithm2::run;
    private static final String[] IN_FILES = {
            "a_example.in",
            "b_should_be_easy.in",
            "c_no_hurry.in",
            "d_metropolis.in",
            "e_high_bonus.in"
    };

    public static void main(String[] args) {
        for (String inFile : IN_FILES) {
            System.out.println("Started to process " + inFile);
            run(ALGORITHM, inFile);
        }
    }

    private static void run(final Function<Input, Output> algorithm, final String inputFileName) {
        Input input = FileHandler.read(inputFileName);

        Output output = algorithm.apply(input);

        FileHandler.write(inputFileName.replace(".in", ".out"), output);
    }
}
