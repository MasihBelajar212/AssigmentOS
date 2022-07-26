// Nama : Ida Bagus Made W
// Nim : 2301878321

import java.io.*;
import java.util.*;

class Sender {
    public void send(String msg) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Isi Pesan :");
        msg = myObj.nextLine();
        System.out.println("Mengirim Pesan:\t" + msg);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
        System.out.println("\n" + "Isi Pesan :" + msg);
    }
}

class ThreadedSend extends Thread {
    private String msg;
    Sender sender;

    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {

        synchronized (sender) {

            sender.send(msg);
        }
    }
}

class SyncDemo {
    public static void main(String args[]) {

        Sender send = new Sender();
        ThreadedSend S1 = new ThreadedSend(" Coba Dulu ", send);

        S1.start();

        try {
            S1.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}