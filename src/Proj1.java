/***********************************************************************
 ∗ @file: Proj1.java
 ∗ @description: This program implements the Proj1 class for invocation and I/O Files.
 ∗ @author: Max Finegan
 ∗ @date: September 24 , 2024
 ***********************************************************************/
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileNotFoundException;

public class Proj1 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }
        new Parser(args[0]);



        // this is for if there was a unique data element for the jobs, but there is not.

//        // For file input
//        FileInputStream inputFileNameStream = null;
//        Scanner inputFileNameScanner = null;
//
//            // Open the input file
//
//            inputFileNameStream = new FileInputStream("./src/jobs_in_data3.csv");
//            inputFileNameScanner = new Scanner(inputFileNameStream);
//
//            // Ignore the first line
//            inputFileNameScanner.nextLine();
//
//            // Create an ArrayList to store the Job data
//            ArrayList<Job> jobData = new ArrayList<Job>();
//            Job currentJob;
//
//            // Read the file line by line
//            while (inputFileNameScanner.hasNext()) {
//                String line = inputFileNameScanner.nextLine();
//                String[] parts = line.split(","); // Split the string into multiple parts
//
//                // Create a new Job object with parsed data
//                Integer workYear = Integer.parseInt(parts[0]);
//                String jobTitle = parts[1];
//                String jobCategory = parts[2];
//                String salaryCurrency = parts[3];
//                Integer salary = Integer.parseInt(parts[4]);
//                Integer salaryInUSD = Integer.parseInt(parts[5]);
//                String employeeResidence = parts[6];
//                String experienceLevel = parts[7];
//                String employmentType = parts[8];
//                String workSetting = parts[9];
//                String companyLocation = parts[10];
//                String companySize = parts[11];
//
//                currentJob = new Job(workYear, jobTitle, jobCategory, salaryCurrency, salary, salaryInUSD,
//                        employeeResidence, experienceLevel, employmentType, workSetting, companyLocation, companySize);
//
//                jobData.add(currentJob);
//
//
//
//        }
//        System.out.println(jobData.get(3));
//
//
//        //new Parser(args[0], jobData);





    }


}