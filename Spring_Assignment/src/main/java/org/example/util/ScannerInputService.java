package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService{

  Scanner scanner;

     @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.print("Enter Name of the student: ");
        String input = scanner.nextLine();
        return input;
    }

    @Override
    public int getInt() {
        System.out.println("Enter Number");
        int input = scanner.nextInt();
        return input;
    }
}
