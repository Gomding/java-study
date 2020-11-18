package javaio;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
    public static void main(String[] args) {
        //
        int[] score = { 1, 100,  90,  90,
                        2,  70,  90, 100,
                        3, 100, 100, 100,
                        4,  70,  60,  80,
                        5,  70,  90, 100
        };

        try {
            RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
            for (int i=0; i < score.length; i++) {
                raf.writeInt(score[i]);
            }

            while (true) {
                System.out.println(raf.readInt());
            }
        }catch (EOFException e) {
            // readInt()를 호출 했을 때 더 이상 읽을 내용이 없으면 EOFException이 발생
        }catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
