class TA extends Student {
    private int teacherID; // Setting variable

    public TA(String fName, String lName, int studentID, int teacherID, long phone) { // Constructor that takes all TA information
        super(fName, lName, studentID, phone); // Calling parent information for first and last name, studentID, and phone
        this.teacherID = teacherID; // Setting TeacherID
    }
    public int getID(){ // Getting the max of studentID and teacherID
        return Math.max(super.getID(),teacherID);
    }
}
