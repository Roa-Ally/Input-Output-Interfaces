import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        try {
        Student info = new Student(); // Creating a new instance of default Student constructor
        System.out.println("Hello how many inputs would you like to make?"); // Welcome message
        System.out.println("Please enter a positive whole number.");
        Scanner scan = new Scanner(System.in); // Scanner
        int totalInputs; // Amount of time the inputs will loop
        totalInputs = scan.nextInt();
        while(totalInputs < 0) { // Checking if totalInputs is a negative number
            System.out.println("Error total number of input must be a positive number Please try again");
            totalInputs = scan.nextInt();

        }

        System.out.println("Please enter " + totalInputs + " amount of inputs in the following format:" ); // Continue message and letting the user know the correct format to input information
        System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
        System.out.println("Press enter when you are done.");

            PrintWriter out = new PrintWriter(new FileWriter("out.csv")); // PrintWriter


            boolean failedInput = false; // Variable to send error message to re-enter information
            int i = 0;


            while (i < totalInputs) { // While loop to loop as long i is less than totalInputs


                if (failedInput) { // Error message asking for re-input if failedInput is true
                    System.out.println("Please re-enter the information using the following format:");
                    System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
                    System.out.println("Press Enter when you are done.");
                }
                scan = new Scanner(System.in); // Scanner
                String input = scan.nextLine(); // Scanning next line into variable input
                String [] personalInfo = input.split(" "); // Splitting up input into an array personalInfo that holds 5 spaces

                if (personalInfo.length != 5) { // If array personalInfo has more or less than 5 spaces it is in an invalid format and to try again
                    System.out.println("Error invalid format! Please try again");
                    failedInput = true; // Call to error message
                    continue; // Start over
                }
                String position = personalInfo[0]; // Position will be set in the array personalInfo of index 0
                if (!info.setPosition(position)) { // Calling the method setPosition
                    failedInput = true;
                    continue;
                }

                String[] name = personalInfo[1].split(","); // Splitting the array personalInfo at index 1 into two input first and last name into another array called name
                String fName = name[0]; // fName will be set in the array name at index 0
                String lName = name[1]; // lName will be set in the array name at index 1

                if (!info.setName(fName)) { // Calling setName method to check first name
                    failedInput = true;
                    continue;
                }

                if (!info.setName(lName)) { // Calling set method to check last name
                    failedInput = true;
                    continue;
                }
                int studentID, teacherID; // Setting variables student and teacherID as ints

                try { // Parsing personalInfo array of index 2 and 3 into integer for student and teacher id in try catch to make sure the inputs are numbers
                    studentID = Integer.parseInt(personalInfo[2]);
                    teacherID = Integer.parseInt(personalInfo[3]);

                } catch (NumberFormatException ex) {
                    System.out.println("Error StudentID TeacherID and Phone have to be numbers! Please try again");
                    continue;
                }

                if (!info.setId(position, studentID, teacherID)) { // Calling setId method
                    failedInput = true;
                    continue;
                }

               String strPhone = personalInfo[4]; // Setting personalInfo array at index 4 into variable strPhone
                if (!info.setPhone(strPhone)){ // Calling the setPhone method
                    failedInput = true;
                    continue;
                }
                int tPhone; // Setting teacher phone into in and the other phone for student and ta into type long
                long phone;
                try { // Parsing strPhone into a integer for teacher phone also only getting the last four digits, Parsing student and ta phone into type long
                    tPhone = Integer.parseInt(strPhone.substring(strPhone.length() - 4));
                    phone = Long.parseLong(strPhone);

                }catch(NumberFormatException ex){
                    System.out.println("Error Phone Number must be number! Please try again");
                    continue;
                }

                CSVPrintable printable; // CSVPrinting if position matches teacher student or ta created a new printable of the appropriate class constructor that takes the correct parameters
                if (position.matches("Student")){
                    printable = new Student(fName,lName,studentID,phone);
                } else if (position.matches("Teacher")) {
                    printable = new Teacher(fName,lName,teacherID, tPhone);
                }else{
                    printable = new TA(fName,lName,studentID,teacherID,phone);
                }
                printable.csvPrintln(out); // Calls the csvPrintln to print the position information it matched with

                i++;
                if(i < totalInputs) { // Message to start being the next input as long as i is less than totalInputs
                    System.out.println("Please enter the information of the next input using the same format."); // Message telling the user to begin next input
                    System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
                    System.out.println("Press Enter when you are done.");
                }
            }
            out.close(); // Closing the print
            System.out.println("Your file has been written"); // Letting you know the file has been written

        }catch(IOException e){ // TBH found this on the internet when researching try catches and csv files I assume it's important so I didn't want to not included it, but idk really know what it does
            e.printStackTrace();
        }

    }
}
