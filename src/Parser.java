/***********************************************************************
 ∗ @file: Parser.java
 ∗ @description: This program implements the Parser class to read a data from the input file.
 ∗ @author: Max Finegan
 ∗ @date: September 24 , 2024
 ***********************************************************************/


import java.io.*;
import java.util.Scanner;

public class Parser {

    private BST<Job> mybst = new BST<>();

    public Parser(String filename) throws FileNotFoundException {
        process(new File(filename));
        writeToFile("./output.txt");
    }


    // makes each line into a Job object and inserts it into binary tree
    public void process(File input) throws FileNotFoundException {
        Scanner reader = new Scanner(input);
        // ignore first line
        reader.nextLine();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (!line.isEmpty()) {
                String[] data = line.split(","); // Split string into multiple parts at commas
                if (data.length == 12) { // Check if the line contains 12 fields
                    try {
                        Job job = new Job(
                                Integer.parseInt(data[0]), // workYear
                                data[1], // jobTitle
                                data[2], // jobCategory
                                data[3], // salaryCurrency
                                Integer.parseInt(data[4]), // salary
                                Integer.parseInt(data[5]), // salaryInUSD
                                data[6], // employeeResidence
                                data[7], // experienceLevel
                                data[8], // employmentType
                                data[9], // workSetting
                                data[10], // companyLocation
                                data[11]  // companySize
                        );
                        mybst.insert(job); // Insert Job object into the BST
                    }
                    catch (NumberFormatException e) {
                        // Handle cases where parsing integer fields fails
                        //writeToFile("Invalid data on line: " + line, "./output.txt");
                        System.out.println("Invalid data on line: " + line);
                    }
                }
                else {
                    //writeToFile("Invalid data on line: " + line, "./output.txt");
                    System.out.println("Invalid data on line: " + line);
                }
            }
        }
        reader.close(); // Close the scanner when done
    }

    // new one with one less parameter

    // Method to sort using the in-order traversal of the BST and write to a file
    public void writeToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Job job : mybst) { // Using the iterator to traverse the BST in-order
                writer.write(job.toString() + "\n"); // Write each job and append a new line
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + filePath);
            e.printStackTrace();
        }
    }

    //old one

//    // Write invalid lines or error messages to an output file
//    private void writeToFile(String content, String filePath) {
//        try (FileWriter writer = new FileWriter(filePath, false)) { // Append mode set to false
//            for (Job job : mybst) { // Using the iterator to traverse the BST in-order
//                writer.write(job.toString() + "\n"); // Write each job and append a newline
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while writing to file: " + filePath);
//            e.printStackTrace();
//        }
//    }








}
