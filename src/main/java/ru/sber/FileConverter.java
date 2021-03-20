package ru.sber;

import java.io.*;

public class FileConverter {

    @FunctionalInterface
    public interface CharConverter {
        int convertChar(int value);
    }

    public static void convert(Reader in, Writer out, CharConverter c) throws IOException {
        int nextChar = in.read();
        while (nextChar >= 0) {
            out.write(c.convertChar(nextChar));
            nextChar = in.read();
        }
    }

    public static void convert(String inFileName, String outFileName, CharConverter c) throws IOException {
        try (FileReader in = new FileReader(inFileName)) {
            try (FileWriter out = new FileWriter(outFileName)) {
                convert(in, out, c);
            }
        }
    }

    public static void convertBuffered(String inFileName, String outFileName, CharConverter c) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(inFileName))) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(outFileName))) {
                convert(in, out, c);
            }
        }
    }
}
