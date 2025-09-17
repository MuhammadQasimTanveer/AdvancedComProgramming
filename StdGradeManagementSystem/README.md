# Student Grade Management System
Console-based Java application developed as the first assignment, enabling users to manage student records, including student IDs, names, and marks for three subjects.

## Features

1. **Add Student** - Add new student with unique IDs, names, and marks for 3 subjects
2. **Update Marks** - Update existing student marks for any subject
3. **Remove Student** - Delete student records from the system
4. **View All Students** - Display complete information for all students
5. **Search Student** - Find specific student data by ID
6. **Highest Scorer** - Identify student(s) with the highest total marks
7. **Class Average** - Calculate and display average marks per subject across all students


## Technical Details

### Requirements
- **Maximum Students**: 50
- **Subjects per Student**: 3
- **Mark Range**: 0-100

### Data Structures Used
- `String[] names` - Stores student names
- `int[] rollNumbers` - Stores unique student IDs  
- `int[][] marks` - 2D array storing marks for 3 subjects per student
- `int n` - Tracks current number of students

## How to Run
```bash
# Compile the program
javac StdGradeManagementSystem .java

# Run the program
java StdGradeManagementSystem 
```

## Sample Output
```
Welcome to Student Grade Management System

1. Add Student
2. Update Marks
3. Remove Student
4. View All Students
5. Search Student
6. Highest Scorer
7. Class Average
8. Exit

Choose an option: 1
Enter Roll No: 20
Enter Name: Muhammad Qasim
Enter Marks in Subject 1: 80
Enter Marks in Subject 2: 70
Enter Marks in Subject 3: 78
Student added successfully!
```

## Limitations
- **Array Size Limit**: Supports up to 50 students only 
- **Fixed Subject Count**: Exactly 3 subjects per student
- **Console Based Interface Only**: No GUI
- **Volatile Data**: All data is lost when the program exits

---
*This project serves as a beginner-level project to understand and practice console-based Java application development.*
