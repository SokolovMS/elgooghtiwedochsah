package com.eight.zero.three;

import com.eight.zero.three.algorithm.number2.GreedyBreedy;
import com.eight.zero.three.file.FileHandler;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

public class MainHandler {
    public static void run(final String inputFileName) {
        Input input = FileHandler.read(inputFileName);

        Output output = GreedyBreedy.run(input);

        FileHandler.write(inputFileName.replace(".in", ".out"), output);
    }
}
