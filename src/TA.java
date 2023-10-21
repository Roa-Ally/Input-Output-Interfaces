class TA extends Student {
    private int teacherID;

    public TA(String fName, String lName, int studentID, int teacherID, long phone) {
        super(fName, lName, studentID, phone);
        this.teacherID = teacherID;
    }
    public int getID(){
        return Math.max(super.getID(),teacherID);
    }
}
