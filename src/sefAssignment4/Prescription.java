package sefAssignment4;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float cylinder;
    private float axis;  
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> remarks = new ArrayList<>();

    //prescription class constructor
    public Prescription(String firstName, String lastName, String address, float sphere, float cylinder, int axis, Date examinationDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;  
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    //to add prescription details to a text file
    public boolean addPrescription() {
        if (validatePrescription()) {
            try (FileWriter writer = new FileWriter("C:\\Users\\charv\\eclipse-workspace\\sefAssignment4\\src\\sefAssignment4\\presc.txt", true)) {
                writer.write(this.toString());  //write prescription to file
                writer.write(System.lineSeparator());
                System.out.println("Prescription written to file.");
                return true;
            } catch (IOException e) {
                System.out.println("Failed to write prescription to file.");
                e.printStackTrace();  //handle file error
                return false;
            }
        } else {
            System.out.println("Prescription validation failed.");
        }
        return false;  //return false if validation fails
    }

    //validate prescription based on the specified conditions
    private boolean validatePrescription() {
        //check first and last name length
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("Validation failed: First name or last name length is invalid. Each should have a minimum of 4 characters and a maximum of 15 characters");
            return false;
        }
        //check address length
        if (address.length() < 20) {
            System.out.println("Validation failed: Address length is invalid, it should have min. 20 characters.");
            return false;
        }
        //check sphere, cylinder, and axis values
        if (sphere < -20.00 || sphere > 20.00 || cylinder < -4.00 || cylinder > 4.00 || axis < 0 || axis > 180) {
            System.out.println("Validation failed: Sphere, cylinder, or axis value is invalid.");
            return false;
        }
        //date format validation (DD/MM/YY)
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            sdf.format(examinationDate);
        } catch (Exception e) {
            System.out.println("Validation failed: Date format is invalid.");
            return false;  // Invalid date format
        }
        //optometrist name length validation
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            System.out.println("Validation failed: Optometrist name length is invalid.");
            return false;
        }
        return true;  //returns true if all conditions are met
    }

    //override toString for saving prescription data in a readable format
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return firstName + " " + lastName + ", Address: " + address + ", Sphere: " + sphere + 
               ", Cylinder: " + cylinder + ", Axis: " + axis + ", Exam Date: " + sdf.format(examinationDate) + 
               ", Optometrist: " + optometrist;
    }

    //function to add a remark to a text file
    public boolean addRemark(String remark, String type) {
        if (validateRemark(remark, type)) {
            try (FileWriter writer = new FileWriter("C:\\Users\\charv\\eclipse-workspace\\sefAssignment4\\src\\sefAssignment4\\remark.txt", true)) {
                writer.write(type + ": " + remark);  //writes remark to file
                writer.write(System.lineSeparator());
                remarks.add(remark);  //adds remark to the list
                System.out.println("Remark written to file.");
                return true;
            } catch (IOException e) {
                System.out.println("Failed to write remark to file.");
                e.printStackTrace();  //handles file writing error
                return false;
            }
        }
        return false;  //returns false if validation fails
    }

    //validate the remark based on the conditions provided
  //validate the remark based on the conditions provided
    private boolean validateRemark(String remark, String type) {
        String[] words = remark.split(" ");
        
        //check word count (must be between 6 and 20 words inclusive)
        if (words.length < 6 || words.length > 20) {
            System.out.println("Validation failed: Remark must contain between 6 and 20 words.");
            return false;
        }
        
        //check that the first word starts with an uppercase letter
        if (!Character.isUpperCase(words[0].charAt(0))) {
            System.out.println("Validation failed: First word must start with an uppercase letter.");
            return false;
        }
        
        //ensure remark type is either "client" or "optometrist"
        if (!type.equalsIgnoreCase("Client") && !type.equalsIgnoreCase("Optometrist")) {
            System.out.println("Validation failed: Remark type is invalid. It must be either 'Client' or 'Optometrist'.");
            return false;
        }
        
        // Ensure the prescription has no more than 2 remarks
        if (remarks.size() >= 2) {
            System.out.println("Validation failed: Maximum number of remarks exceeded (max 2 remarks).");
            return false;
        }
        
        return true;  //return true if all conditions are met
    }

}
