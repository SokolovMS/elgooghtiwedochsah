package com.eight.zero.three.file;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static Input read(final String fileName) {
        BufferedReader br = null;
        FileReader fr = null;

        int r, c, l, h;
        char [][] arr;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine = br.readLine();
            String[] split = sCurrentLine.split(" ");
            r = Integer.parseInt(split[0]);
            c = Integer.parseInt(split[1]);
            l = Integer.parseInt(split[2]);
            h = Integer.parseInt(split[3]);

            arr = new char[r][c];

            for (int i = 0; i < r; i++) {
                sCurrentLine = br.readLine();

                for (int j = 0; j < c; j++) {
                    arr[i][j] = sCurrentLine.charAt(j);
                }
            }

            return new Input(r, c, l, h, arr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void write(final String fileName, final Output output) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileName, true);
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
