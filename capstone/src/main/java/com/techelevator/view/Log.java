package com.techelevator.view;

import java.awt.print.PrinterGraphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Log {


    public static void main(String[] args){
        Log logWriter = new Log();

    }

    public static void run(String option, double price, double remainingChange) {
        File file = new File("C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-1\\capstone\\Log.txt");
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))){
//   Each purchase must generate a line in a file called Log.txt.
//   The lines must follow the format shown in the following example.
//   The first dollar amount is the amount deposited, spent, or given as change.
//   The second dollar amount is the new balance.

//            01/01/2019 12:00:00 PM FEED MONEY: $5.00 $5.00
//            01/01/2019 12:00:15 PM FEED MONEY: $5.00 $10.00
//            01/01/2019 12:00:20 PM Crunchie B4 $1.75 $8.25
//            01/01/2019 12:01:25 PM Cowtales B2 $1.50 $6.75
//            01/01/2019 12:01:35 PM GIVE CHANGE: $6.75 $0.00
            while (true){
                writer.println(option + ": $" + price + " $" + remainingChange);
                break;
            }



        } catch (Exception ex){
            System.out.println("Something went wrong!");
        }
    }

}
