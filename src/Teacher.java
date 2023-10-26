import java.io.PrintWriter;

class Teacher implements CSVPrintable{
    private String fName, lName; // Setting variables
    private int teacherID;
    private int tPhone;

    public Teacher(String fName, String lName, int teacherID, int tPhone){ // Constructor that takes all teacher information
        this.fName = fName.substring(0,1).toUpperCase() + fName.substring(1);
        this.lName = lName.substring(0,1).toUpperCase() + lName.substring(1);
        this.teacherID = teacherID;
        this.tPhone = tPhone;
    }
    @Override
    public String getName() { // Getting name in the correct format of firstName,lastName
        return fName + "," + lName;
    }

    @Override
    public int getID() { // Getting studentID
        return teacherID;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + tPhone); //Printing out in the correct format of name,ID,phone

    }
}
