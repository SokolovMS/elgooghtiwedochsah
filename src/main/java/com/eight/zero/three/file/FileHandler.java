package com.eight.zero.three.file;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public static final String IN_FOLDER = "src/main/resources/";
    public static final String OUT_FOLDER = "target/";
    public static final int RIDES_PARAMS_NUMBER = 6;

    public static Input read(final String fileName) {
        final String path = IN_FOLDER + fileName;

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        int r, c, f, n, b, t;
        int [][] rides;

        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            String sCurrentLine = bufferedReader.readLine();
            String[] split = sCurrentLine.split(" ");
            r = Integer.parseInt(split[0]);
            c = Integer.parseInt(split[1]);
            f = Integer.parseInt(split[2]);
            n = Integer.parseInt(split[3]);
            b = Integer.parseInt(split[4]);
            t = Integer.parseInt(split[5]);

            rides = new int[n][RIDES_PARAMS_NUMBER];

            for (int i = 0; i < n; i++) {
                sCurrentLine = bufferedReader.readLine();
                String[] rideSplit = sCurrentLine.split(" ");

                for (int j = 0; j < RIDES_PARAMS_NUMBER; j++) {
                    rides[i][j] = Integer.parseInt(rideSplit[j]);
                }
            }

            return new Input(r, c, f, n, b, t, rides);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void write(final String fileName, final Output output) {
        final String path = OUT_FOLDER + fileName;

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(path, false);
            bw = new BufferedWriter(fw);

            bw.append(output.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
