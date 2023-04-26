package com.epam.mjc.io;

import java.io.*;

public class FileReader {


    public Profile getDataFromFile(File file) {
        Profile profile = null;

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                switch (parts[0]) {
                    case "Name":
                        profile = new Profile(parts[1].trim(), 0, null, null);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(parts[1].trim()));
                        break;
                    case "Email":
                        profile.setEmail(parts[1].trim());
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(parts[1].trim()));
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

      // System.out.println(profile);
        return profile;
    }
}
