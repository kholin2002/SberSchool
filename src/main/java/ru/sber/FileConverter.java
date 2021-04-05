package ru.sber;

import java.io.*;

public class FileConverter {

    @FunctionalInterface
    public interface CharConverter {
        int convertChar(int value);
    }

    public static void convert(Reader in, Writer out, CharConverter converter) throws IOException {
        int nextChar = in.read();
        while (nextChar >= 0) {
            out.write(converter.convertChar(nextChar));
            nextChar = in.read();
        }
    }

    public static void convert(String inFileName, String outFileName, CharConverter converter) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(inFileName))) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(outFileName))) {
                convert(in, out, converter);
                out.flush();
            }
        }
    }
}
