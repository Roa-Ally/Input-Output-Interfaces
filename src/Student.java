import java.io.PrintWriter;

class Student implements CSVPrintable {
    private String fName, lName; // Setting variables
    private long phone;
    private int studentID;

    public Student(){ // Default constructor that i can use to call the methods i created
    }
    public Student(String fName, String lName, int studentID, long phone){ // Constructor that takes all student information
        this.fName = fName.substring(0,1).toUpperCase() + fName.substring(1); // converts first letter of first and last name to capital to have consistent formatting everything returns as is
        this.lName = lName.substring(0,1).toUpperCase() + lName.substring(1);
        this.studentID = studentID;
        this.phone = phone;
    }
    @Override
    public String getName() {
        return fName + " " + lName;
    }
    @Override
    public int getID() {
        return studentID;
    } // Getting studentID
    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName()+ "," + getID() + "," + phone); //Printing out in the correct format of name,ID,phone
    }
    public boolean setPosition(String position){ // Receives String input of position and check if position is one of the three options listed if not return false to send the appropriate error message trigger the re-input message and to start over
        if (!(position.matches("Student") || position.matches("Teacher") || position.matches("TA"))){
            System.out.println("Error position must match \"Student, Teacher, or TA\"! Please try again");
            return false;
        }
        return true; // Else return true to continue the code
    }
    public boolean setName(String name){ // Receives String input name either first or last and checks if it contains any digits and if it has any return the appropriate error message
        for(int i = 0; i < name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                System.out.println("Error name cannot contain digits! Please try again");
                return false;
            }
        }
        return true;
    }
    public boolean setId(String position, int studentID, int teacherID){ // Receives String input position int input studentID and int input teacherID and send the appropriate error message if if-statements are met
        if (position.matches("Teacher")){ // If position matches teacher convert the teacherID into to string to check the length and if studentID is 0
            String strT = Integer.toString(teacherID);
            if (strT.length() != 5){
                System.out.println("Error TeacherID must be 5 digits");
                return false;
            } else if (studentID != 0) {
                System.out.println("Error if position is Teacher StudentID must be 0");
                return false;
            }
        } else if (position.matches("Student")) { // If position matches Student convert the studentID into a string to check length and if teacherID is 0
            String strS = Integer.toString(studentID);
            if (strS.length() != 5){
                System.out.println("Error StudentId must be 5 digits");
                return false;
            } else if (teacherID != 0) {
                System.out.println("Error is position is Student TeacherID must be 0");
                return false;
            }

        } else if (position.matches("TA")) { // If position matches TA check if student or teacherID is 0 then convert both into a string to check length
            if (teacherID == 0 || studentID == 0){
                System.out.println("If position is TA TeacherID and StudentID cannot be 0");
                return false;
            } else {
                String strTAS = Integer.toString(studentID);
                String strTAT = Integer.toString(teacherID);
                if (strTAS.length() !=5 || strTAT.length() != 5){
                    System.out.println("Error TeacherID and StudentID must be 5 digits");
                    return false;
                }
            }
        }
        return true;
    }
    public boolean setPhone(String strPhone){ // Receives string input strPhone and checks length
        if (strPhone.length() != 10){
            System.out.println("Error phone must be 10 digits");
            return false;

        }  return true;
    }
    }




