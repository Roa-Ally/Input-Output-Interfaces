# Programming-2-Assignment-3
User enters personal information of n students and teachers using the console in the following
format:
n
Position1 Name1 StudentID1 TeacherID1 Phone1
Position2 Name2 StudentID2 TeacherID2 Phone2
Position3 Name3 StudentID3 TeacherID3 Phone3
. . .
Positionn Namen StudentIDn TeacherIDn Phonen
Please note that the first line contains only an integer counting the number of lines
following the first line.
In each of the n given input lines,
 Position must be one of the following three strings “student”, “teacher”, or “TA”.
 Name must be a string of two words separated by a single comma only.
 StudentID and TeacherID must be either “0” or a string of 5 digits. If Position is
“teacher”, StudentID is zero, but TeacherID is not zero. If Position is “student”,
TeacherID is zero, but StudentID is not zero. If Position is “TA”, neither StudentID
nor TeacherID are zero.
 Phone is a string of 10 digits

If the user enters information in a way that is not consistent with the mentioned format, your
program must gracefully handle the situation by printing a message on the screen asking the
user to partially/completely re-enter the information that was previously entered in a wrong
format

The program must store the personal information of students, teachers and TAs in a comma-
separated values (.csv) file called “out.csv”. You need to construct the output file by repet-
itively calling the csvPrintln method of every CSVPrintable object instantiated in your
program. The output .csv file stores the information of every individual in a separate row;
while each column of the file stores different type of information regarding the students and
teachers (i.e. Name, ID and phone columns). Please note that you should be able to open
the output file of your program using MS-Excel and view it as a table

