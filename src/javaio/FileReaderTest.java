package javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderTest {

    public static ArrayList readCharstream(String fileName) throws Exception{

        ArrayList<StringBuffer> list = new ArrayList<>();
        FileReader fr = null;

        try {
            fr = new FileReader(fileName); // FileReader 객체 생성
            int data = 0;
            // 한 줄씩 데이터를 담을 StringBuffer 생성
            StringBuffer sb = new StringBuffer();
            while ((data = fr.read()) != -1) {
                if (data == '\n' || data == '\r') {
                    list.add(sb);
                    sb = new StringBuffer();
                } else {
                    sb.append((char)data);
                }
            }
        }catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }finally {
            if(fr != null) fr.close();
        }

        return list;
    }

    public static String readCharStreamWithBuffer(String fileName) throws Exception {

        StringBuffer retSB = new StringBuffer();
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
            int bufferSize=1024*1024;
            char[] readBuffer = new char[bufferSize];
            int resultSize = 0;

            while((resultSize = fr.read(readBuffer)) != -1) {

                if(resultSize == bufferSize) {
                    retSB.append(readBuffer);
                } else {
                    for(int loop = 0; loop < resultSize; loop++) {
                        retSB.append(readBuffer[loop]);
                    }
                }
            }

        }catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }finally {
            if(fr != null) fr.close();
        }

        return retSB.toString();
    }

    public static ArrayList<String> readBufferedReader(String fileName) throws Exception{

        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while((data = br.readLine()) != null) {
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) br.close();
        }
        return list;
    }


    public static void main(String[] args) throws Exception{

        String fileName = "D:\\10MBFile.txt";
        long start = System.currentTimeMillis();
        ArrayList list1 = FileReaderTest.readCharstream(fileName);
        long end = System.currentTimeMillis();
        long time = (end - start);
        System.out.println(time);
        System.out.println(list1.size());

        long start2 = System.currentTimeMillis();
        String list2 = FileReaderTest.readCharStreamWithBuffer(fileName);
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        System.out.println(time2);
        System.out.println(list2.length());

        long start3 = System.currentTimeMillis();
        ArrayList list3 = FileReaderTest.readBufferedReader(fileName);
        long end3 = System.currentTimeMillis();
        long time3 = end3 - start3;
        System.out.println(time3);
        System.out.println(list3.size());

    }


}
