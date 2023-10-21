import java.io.PrintWriter;

class Student implements CSVPrintable {
    private String fName, lName;
    private long phone;
    private int studentID;

    public Student(){

    }
    public Student(String fName, String lName, int studentID, long phone){
        this.fName = fName;
        this.lName = lName;
        this.studentID = studentID;
        this.phone = phone;
    }
    @Override
    public String getName() {
        return fName + "," + lName;
    }

    @Override
    public int getID() {
        return studentID;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName()+ "," + getID() + "," + phone);

    }
    public boolean setPosition(String position){
        if (position.matches("Student") || position.matches("Teacher") || position.matches("TA")){
            System.out.println("Error position must match \" Student, Teacher, or TA\"! Please try again");
            return false;
        }
        return true;
    }

    public boolean setName(String name){
        for(int i = 0; i < name.length(); i++){
            if(Character.isDigit(name.charAt(i))){
                System.out.println("Error name cannot contain digits! Please try again");
                return false;
            }else{
               String capitalName = name.substring(0,1).toUpperCase() + name.substring(1);
               name = capitalName;
            }
        }
        return true;
    }

    public boolean setId(String position, int studentID, int teacherID){
        if (position.matches("Teacher")){
            String strT = Integer.toString(teacherID);
            if (strT.length() != 5){
                System.out.println("Error TeacherID must be 5 digits");
                return false;
            } else if (studentID != 0) {
                System.out.println("Error if position is Teacher StudentID must be 0");
                return false;
            }
        } else if (position.matches("Student")) {
            String strS = Integer.toString(studentID);
            if (strS.length() != 5){
                System.out.println("Error StudentId must be 5 digits");
                return false;
            } else if (teacherID != 0) {
                System.out.println("Error is position is Student TeacherID must be 0");
                return false;
            }

        } else if (position.matches("TA")) {

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
    public boolean setPhone(String position, String strPhone){
        if (strPhone.length() != 10){
            System.out.println("Error phone must be 10 digits");
            return false;
        } else if () {
            
        }

    }



}
