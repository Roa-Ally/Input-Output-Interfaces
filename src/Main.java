import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        try {
        Student info = new Student();
        System.out.println("Hello how many inputs would you like to make?");
        System.out.println("Please enter a positive whole number.");
        Scanner scan = new Scanner(System.in);
        int totalInputs;
        totalInputs = scan.nextInt();
        while(totalInputs < 0) {
            System.out.println("Error total number of input must be a positive number Please try again");
            totalInputs = scan.nextInt();

        }

        System.out.println("Please enter " + totalInputs + " amount of inputs in the following format:" );
        System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
        System.out.println("Press enter when you are done.");

            PrintWriter out = new PrintWriter(new FileWriter("out.csv"));


            boolean failedInput = false;
            int i = 0;


            while (i < totalInputs) {


                if (failedInput) {
                    System.out.println("Please re-enter the information using the following format:");
                    System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
                    System.out.println("Press Enter when you are done.");
                }
                scan = new Scanner(System.in);
                String input = scan.nextLine();
                String [] personalInfo = input.split(" ");

                if (personalInfo.length != 5) {
                    System.out.println("Error invalid format!");
                    failedInput = true;
                    continue;
                }
                String position = personalInfo[0];
                if (!info.setPosition(position)) {
                    failedInput = true;
                    continue;
                }

                String[] name = personalInfo[1].split(",");
                String fName = name[0];
                String lName = name[1];

                if (!info.setName(fName)) {
                    failedInput = true;
                    continue;
                }

                if (!info.setName(lName)) {
                    failedInput = true;
                    continue;
                }
                int studentID, teacherID;

                try {
                    studentID = Integer.parseInt(personalInfo[2]);
                    teacherID = Integer.parseInt(personalInfo[3]);

                } catch (NumberFormatException ex) {
                    System.out.println("Error StudentID TeacherID and Phone have to be numbers! Please try again");
                    continue;
                }

                if (!info.setId(position, studentID, teacherID)) {
                    failedInput = true;
                    continue;
                }

               String strPhone = personalInfo[4];
                if (!info.setPhone(strPhone)){
                    failedInput = true;
                    continue;
                }
                int tPhone;
                long phone;
                try {
                    tPhone = Integer.parseInt(strPhone.substring(strPhone.length() - 4));
                    phone = Long.parseLong(strPhone);

                }catch(NumberFormatException ex){
                    System.out.println("Error Phone Number must be number! Please try again");
                    continue;
                }

                CSVPrintable printable;
                if (position.matches("Student")){
                    printable = new Student(fName,lName,studentID,phone);
                } else if (position.matches("Teacher")) {
                    printable = new Teacher(fName,lName,teacherID, tPhone);
                }else{
                    printable = new TA(fName,lName,studentID,teacherID,phone);
                }
                printable.csvPrintln(out);

                i++;
                if(i < totalInputs) {
                    System.out.println("Please enter the information of the next input using the same format."); // Message telling the user to input more student information until they are "DONE"
                    System.out.println("Position FirstName,LastName StudentID TeacherID Phone");
                    System.out.println("Press Enter when you are done.");
                }
                failedInput = false;
            }

            out.close();
            System.out.println("Your file has been written");

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
