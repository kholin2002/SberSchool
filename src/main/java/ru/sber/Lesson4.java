package ru.sber;

import java.io.IOException;
import java.util.Date;

public class Lesson4 {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        String fileNameIn = args[0];
        String fileNameOut = args.length == 1 ? fileNameIn + "_out" : args[1];
        Date dateStart = new Date();
        System.out.printf("%1$tT.%1$tL Converting file \"%2$s\" to \"%3$s\"\n", dateStart, fileNameIn, fileNameOut);

        FileConverter.convertBuffered(fileNameIn, fileNameOut, (chr) -> chr == '0' ? ' ' : chr);

        Date dateStop = new Date();
        System.out.printf("%1$tT.%1$tL Done.\nExecution time (ms): %2$d\n", dateStop, dateStop.getTime() - dateStart.getTime());
    }
}
