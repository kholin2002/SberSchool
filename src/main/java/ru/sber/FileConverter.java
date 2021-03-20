package ru.sber;

import java.io.*;

public class FileConverter {

    @FunctionalInterface
    public interface CharConverter {
        int convert(int value);
    }

    public static void Convert(Reader in, Writer out, CharConverter c) throws IOException {
        int nextChar = in.read();
        while (nextChar > 0) {
            out.write(c.convert(nextChar));
            nextChar = in.read();
        }
    }

    public static void Convert(String inFileName, String outFileName, CharConverter c) throws IOException {
        try (FileReader in = new FileReader(inFileName)) {
            try (FileWriter out = new FileWriter(outFileName)) {
                Convert(in, out, c);
            }
        }
    }

    public static void ConvertBuffered(String inFileName, String outFileName, CharConverter c) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(inFileName))) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(outFileName))) {
                Convert(in, out, c);
            }
        }
    }
}
