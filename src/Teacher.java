import java.io.PrintWriter;

class Teacher implements CSVPrintable{
    private String fName, lName;
    private int teacherID;
    private int phone;

    public Teacher(String fName, String lName, int teacherID, int phone){
        this.fName = fName;
        this.lName = lName;
        this.teacherID = teacherID;
        this.phone = phone;
    }
    @Override
    public String getName() {
        return fName + "," + lName;
    }

    @Override
    public int getID() {
        return teacherID;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + phone);

    }
}
