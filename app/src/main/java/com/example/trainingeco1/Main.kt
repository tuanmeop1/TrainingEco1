package com.example.trainingeco1

import com.example.trainingeco1.data.StudentData
import com.example.trainingeco1.extensions.StudentExtension

fun main() {
    val studentList = StudentData.studentList
    var classifiedListByAcademic: MutableMap<String, Int>

    print("HELLO THIS IS STUDENT MANAGEMENT SYSTEM\n")
    print("=======================================\n")

    while(true) {
        printHelpMenu()
        print("Enter your choice: ")
        val userChoice = readln().toIntOrNull()
        if (userChoice == null) {
            println("Invalid input! Please enter a NUMBER")
            continue
        }
        when(userChoice) {
            1 -> StudentExtension.printStudentList(studentList)
            2 -> StudentExtension.addStudent(studentList)
            3 -> StudentExtension.printScholarshipStudentList(studentList)
            4 -> StudentExtension.setGPAForAllStudent(studentList)
            5 -> StudentExtension.setGPAByID(studentList)
            6 -> StudentExtension.printStudentList(StudentExtension.getStudentListWithDuplicateGPA(studentList))
            7 -> print(StudentExtension.mapIDtoName(studentList))
            8 -> {
                for (student in studentList) {
                    print("Student name: ${student.name}, is classify as ${student.classificationByAge()}\n")
                }
            }
            9 -> {
                val al = studentList.sortedByDescending { it.gpa }
                StudentExtension.printStudentList(studentList)
                StudentExtension.printStudentList(al)
            }
            10 -> {
                classifiedListByAcademic = StudentExtension.classifyByAcademicPerformance(studentList).toMutableMap()
                print(classifiedListByAcademic)
            }
            11 -> {
                println("Exiting program...")
                break
            }
            else -> print("Please enter the right number!\n")
        }

    }

}

fun printHelpMenu() {
    print("Please enter:\n" +
            "\t 1 to print complete information of all student\n" +
            "\t 2 to add new student to the list\n" +
            "\t 3 to print the list of students who are eligible for a scholarship\n" +
            "\t 4 to iterate through the entire student list and set GPA for each student\n" +
            "\t 5 to set the GPA for a student by ID\n" +
            "\t 6 to get the list of all students who share a duplicate GPA with others\n" +
            "\t 7 to get the map that maps student IDs to their names\n" +
            "\t 8 to classify and print student by age\n" +
            "\t 9 to sort the student list by GPA (descending list)\n" +
            "\t 10 to statistics on the number of students according to each academic performance level\n" +
            "\t 11 to stop the program\n")
}
