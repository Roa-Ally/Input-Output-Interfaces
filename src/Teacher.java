import java.io.PrintWriter;

class Teacher implements CSVPrintable{
    private String fName, lName;
    private int teacherID;
    private int tPhone;

    public Teacher(String fName, String lName, int teacherID, int tPhone){
        this.fName = fName.substring(0,1).toUpperCase() + fName.substring(1);
        this.lName = lName.substring(0,1).toUpperCase() + lName.substring(1);
        this.teacherID = teacherID;
        this.tPhone = tPhone;
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
        out.println(getName() + "," + getID() + "," + tPhone);

    }
}
