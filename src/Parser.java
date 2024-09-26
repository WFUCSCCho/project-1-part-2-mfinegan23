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

    // Constructor that initializes the parser with the filename to process
    public Parser(String filename) throws FileNotFoundException {
        process(new File(filename));
    }

    // Method to process the file and execute commands on the BST
    public void process(File input) throws FileNotFoundException {

        Scanner reader = new Scanner(input);
        while (reader.hasNextLine()) {
            // Gets rid of leading and trailing spaces, replaces all instances of multiple spaces with just one space
            String line = reader.nextLine().trim().replaceAll("\\s+", " ");
            if (!line.isEmpty()) {
                // splits the input into a command and a job
                String[] command = line.split(" ");

//                String[] jobData = command[1].split(",");
//                if (jobData.length == 12) { // Check if the line contains 12 fields
//                    //try {
//                        Job job = new Job(
//                                Integer.parseInt(jobData[0]), // workYear
//                                jobData[1], // jobTitle
//                                jobData[2], // jobCategory
//                                jobData[3], // salaryCurrency
//                                Integer.parseInt(jobData[4]), // salary
//                                Integer.parseInt(jobData[5]), // salaryInUSD
//                                jobData[6], // employeeResidence
//                                jobData[7], // experienceLevel
//                                jobData[8], // employmentType
//                                jobData[9], // workSetting
//                                jobData[10], // companyLocation
//                                jobData[11]  // companySize
//                        );
//                        //mybst.insert(job); // Insert Job object into the BST
//                    //}
////                    catch (NumberFormatException e) {
////                        // Handle cases where parsing integer fields fails
////                        //writeToFile("Invalid data on line: " + line, "./output.txt");
////                        System.out.println("Invalid data on line: " + line);
////                    }
//                }
//                else {
//                    //writeToFile("Invalid data on line: " + line, "./output.txt");
//                    System.out.println("Invalid data on line: " + line);
//                }


                operate_BST(command); // Do the command
            }
        }
        reader.close();
    }

    // Interprets the incoming command and operates on the BST
    public void operate_BST(String[] command) {

        try {

            switch (command[0].toLowerCase()) {
                case "insert" -> {

                    // split the job from the input file
                    String[] jobData = command[1].split(",");
                        // make a new Job object
                        Job job = new Job(
                                Integer.parseInt(jobData[0]), // workYear
                                jobData[1], // jobTitle
                                jobData[2], // jobCategory
                                jobData[3], // salaryCurrency
                                Integer.parseInt(jobData[4]), // salary
                                Integer.parseInt(jobData[5]), // salaryInUSD
                                jobData[6], // employeeResidence
                                jobData[7], // experienceLevel
                                jobData[8], // employmentType
                                jobData[9], // workSetting
                                jobData[10], // companyLocation
                                jobData[11]  // companySize
                        );

                        // Insert the job into the BST
                        mybst.insert(job);
                        // Write the result to the result.txt file
                        writeToFile("insert " + job, "./src/output.txt");


                }
                case "search" -> {

                    // split the job spaces
                    String[] jobData = command[1].split(",");

                    // make the input into a Job object
                        Job job = new Job(
                                Integer.parseInt(jobData[0]), // workYear
                                jobData[1], // jobTitle
                                jobData[2], // jobCategory
                                jobData[3], // salaryCurrency
                                Integer.parseInt(jobData[4]), // salary
                                Integer.parseInt(jobData[5]), // salaryInUSD
                                jobData[6], // employeeResidence
                                jobData[7], // experienceLevel
                                jobData[8], // employmentType
                                jobData[9], // workSetting
                                jobData[10], // companyLocation
                                jobData[11]  // companySize
                        );

                        // Search the tree for the job
                        Node<Job> foundNode = mybst.search(job);

                        if (foundNode != null) {
                            writeToFile("found " + job, "./src/output.txt");
                        }
                        else {
                            writeToFile("search failed", "./src/output.txt");
                        }


                }
                case "remove" -> {

                    // split the job from the input file
                    String[] jobData = command[1].split(",");

                        Job job = new Job(
                                Integer.parseInt(jobData[0]), // workYear
                                jobData[1], // jobTitle
                                jobData[2], // jobCategory
                                jobData[3], // salaryCurrency
                                Integer.parseInt(jobData[4]), // salary
                                Integer.parseInt(jobData[5]), // salaryInUSD
                                jobData[6], // employeeResidence
                                jobData[7], // experienceLevel
                                jobData[8], // employmentType
                                jobData[9], // workSetting
                                jobData[10], // companyLocation
                                jobData[11]  // companySize
                        );


                        Node<Job> removedNode = mybst.search(job);
                        if (removedNode != null) {
                            mybst.remove(job);
                            writeToFile("removed " + job, "./src/output.txt");
                        } else {
                            writeToFile("remove failed", "./src/output.txt");
                        }



                }
                case "print" -> {
                    // StringBuilder is used to store the in-order traversal of the tree
                    StringBuilder sb = new StringBuilder();
                    // Iterate over the BST and append each value to the StringBuilder (enhanced for loop uses iterator "under the hood")
                    for (Job job : mybst) {
                        sb.append(job).append(" " + "\n"); // when printing multiple jobs, it prints each job on a new line
                    }

                    // Without for each loop
//                    // Manually create an iterator for the BST
//                    Iterator<Job> iterator = mybst.iterator();
//
//                    // Use the iterator to traverse through the tree's elements
//                    while (iterator.hasNext()) {
//                        sb.append(iterator.next()).append(" " + "\n");
//                    }

                    // Write the in-order traversal to the result.txt filer. Remove any leading or trailing spaces
                    writeToFile(sb.toString().trim(), "./src/output.txt");
                }

                // a new job only gets inserted/removed/searched for if it has 12 elements in the correct order, with three being integers
                // Default case for invalid commands
                default -> writeToFile("Invalid Command", "./src/output.txt");
            }

        }
        catch (Exception e) {
            // In case of any errors (ex: invalid command format)
            writeToFile("Invalid Command", "./src/output.txt");
        }
    }

    // Writes content to the specified file
    public void writeToFile(String content, String filePath) {

//        PrintWriter fileWriter;
//        FileOutputStream result = null;
//        try {
//            result = new FileOutputStream("result.txt", true);
//        } catch (FileNotFoundException e)
//        {
//            System.out.println ("File could not be opened for output- closing program");
//            System.exit(1);
//        }


        FileWriter writer = null;

        try {
            writer = new FileWriter(filePath, true);
            writer.write(content);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}
