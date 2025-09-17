# Student Grade Management System

Console-based Java application developed as the 1st assignment that allows users to manage student records including their IDs, names, and marks for three subjects.

## Features

### Core Functionalities
1. **Add Student** - Register new students with unique IDs, names, and marks for 3 subjects
2. **Update Marks** - Modify existing student marks for any subject
3. **Remove Student** - Delete student records from the system
4. **View All Students** - Display complete information for all registered students
5. **Search Student** - Find and display specific student information by ID
6. **Highest Scorer** - Identify student(s) with the highest total marks
7. **Class Average** - Calculate and display average marks per subject across all students

### Data Validation
- Student IDs must be unique
- Marks must be within the range of 0-100
- Input validation for menu choices and subject numbers

## Technical Specifications

### System Constraints
- **Maximum Students**: 50
- **Subjects per Student**: 3 (fixed)
- **Mark Range**: 0-100

### Data Structures Used
- `String[] studentName` - Stores student names
- `int[] studentId` - Stores unique student IDs  
- `double[][] marks` - 2D array storing marks for 3 subjects per student
- `int n` - Tracks current number of students

## How to Run

### Prerequisites
- JDK 8 or higher or command line

### Compilation and Execution
```bash
# Compile the program
javac .java

# Run the program
java 
```

## Sample Usage
```
Welcome to Student Grade Management System

1. Add Student.
2. Update Marks.
3. Remove Student.
4. View All Students.
5. Search Student by Id.
6. Highest Scorer.
7. Class Average.
8. Exit

Enter your choice: 1

Enter student's Id: 20
Enter students's name: Muhammad Qasim
Enter marks for subject 1 (0–100): 85
Enter marks for subject 2 (0–100): 92
Enter marks for subject 3 (0–100): 78
```

### Limitations
- **No Data Persistence**: All data is lost when the program terminates
- **Fixed Subject Count**: Limited to exactly 3 subjects
- **Array Size Limit**: Maximum of 50 students
- **No File I/O**: Cannot import/export student data
- **Console Interface Only**: No graphical user interface

---
*This project serves as a foundation for understanding console-based application development in Java.*
