package com.philemmons;

import java.io.*;

public class JavaTutFiles {

    public static void main(String[] args) {

        File f1 = new File("f1.log");
        try {
            if (f1.createNewFile()) {
                System.out.println("File Created");
                f1.renameTo(new File("f1BU.log"));
                f1.delete();
            } else {
                System.out.println("File not created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Moving right along");
        }

        File d1 = new File("/");
        if (d1.isDirectory()) {
            File[] files = d1.listFiles();

            for (File x : files) {
                System.out.println(x.getName());
            }
        }

        File f2 = new File("f2.txt");
        try {
            PrintWriter pw
                    = new PrintWriter(new BufferedWriter(new FileWriter(f2)));

            pw.println("This is sample Text.");
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        f2 = new File("f2.txt");
        try {
            BufferedReader bR = new BufferedReader(new FileReader(f2));
            String text = bR.readLine();
            while (text != null) {
                System.out.println(text);
                text = bR.readLine();
            }
            bR.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        File f3 = new File("f3.dat");

        try {
            FileOutputStream fOS = new FileOutputStream(f3);
            BufferedOutputStream bOS
                    = new BufferedOutputStream(fOS);
            DataOutputStream dOS = new DataOutputStream(bOS);

            String name = "Phillip";
            int age = 99;
            double bal = 51.50;

            dOS.writeUTF(name);
            dOS.writeInt(age);
            dOS.writeDouble(bal);
            dOS.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        f3 = new File("f3.dat");

        FileInputStream fIS;

        try {
            fIS = new FileInputStream(f3);
            BufferedInputStream bIS = new BufferedInputStream(fIS);

            DataInputStream dIS = new DataInputStream(bIS);
            System.out.println(dIS.readUTF());
            System.out.println(dIS.readInt());
            System.out.println(dIS.readDouble());

            fIS.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
