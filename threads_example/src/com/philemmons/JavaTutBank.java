package com.philemmons;

public class JavaTutBank {

    public static void main(String[] args) {

        ThreadTest threadT1 = new ThreadTest(new Customer("Sam"));
        threadT1.start();
        ThreadTest threadT2 = new ThreadTest(new Customer("Sue"));
        threadT2.start();
        ThreadTest threadT3 = new ThreadTest(new Customer("Sid"));
        threadT3.start();
    }

}

class Customer {
    public String name;

    public Customer(String name) {
        this.name = name;
    }
}

class BankAccount {
    static BankAccount account;
    static int balance = 100;
    static Customer cust;

    public static BankAccount getAccount(Customer cust) {
        if (account == null) {
            account = new BankAccount();
        }

        BankAccount.cust = cust;
        return account;
    }

    public static int getBalance(){
        return balance;
    }

    public synchronized void withDraw(int bal){
        try {
            if(balance >= bal){
                System.out.println(cust.name + " requested $"+ bal);
                Thread.sleep(1000);
                balance -= bal;
                System.out.println( cust.name + "received $"+ bal);
            } else{
                System.out.println( cust.name +  " tried to exceed balance.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("    Current balance: $" + balance + "\n");
    }
}

class ThreadTest extends Thread implements Runnable{
    Customer cust;
    public ThreadTest(Customer cust){
        this.cust = cust;
    }

    public void run(){
        for(int i = 0; i < 4; i++){
            try {
                BankAccount account = BankAccount.getAccount(cust);
                account.withDraw(10);
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Active thread: " + Thread.activeCount());
        System.out.println("Start thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End thread: " + Thread.currentThread().getName());
    }
}
