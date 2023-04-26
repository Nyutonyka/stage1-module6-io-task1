package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            String name = null;
            int age = 0;
            String email = null;
            Long phone = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                switch (parts[0]) {
                    case "Name":
                        name = parts[1].trim();
                        break;
                    case "Age":
                        age = Integer.parseInt(parts[1].trim());
                        break;
                    case "Email":
                        email = parts[1].trim();
                        break;
                    case "Phone":
                        phone = Long.parseLong(parts[1].trim());
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }
            profile = new Profile(name, age, email, phone);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return profile;
    }
}
