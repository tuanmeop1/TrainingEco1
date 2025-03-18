package com.example.trainingeco1

const val MIN_SCHOLARSHIP_GPA = 8.0

const val ADOLESCENT = "Vi thanh nien"
const val STUDENT = "Sinh vien"
const val GRADUATE_OR_WORKING = "Da tot nghiep hoac di lam"

fun main() {
    val studentList = mutableListOf(
        Student(1, "Nguyen Van A", 19, 8.5f, 'M', true),
        Student(2, "Tran Thi B", 22, 6.2f, 'F', false),
        Student(3, "Le Van C", 17, 9.0f, 'M', true),
        Student(4, "Pham Thi D", 21, 5.5f, 'F', false),
        Student(5, "Hoang Van E", 20, 7.8f, 'M', false),
        Student(6, "Nguyen Thi F", 23, 8.9f, 'F', true),
        Student(7, "Do Van G", 18, 6.7f, 'M', false),
        Student(8, "Pham Van H", 19, 9.2f, 'M', true),
        Student(9, "Le Thi I", 20, 6.9f, 'F', false),
        Student(10, "Vu Van J", 22, 8.0f, 'M', true),
        Student(11, "Bui Thi K", 18, 7.0f, 'F', false),
        Student(12, "Ngo Van L", 23, 9.5f, 'M', true),
        Student(13, "Pham Thi M", 21, 6.2f, 'F', false),
        Student(14, "Tran Van N", 19, 7.6f, 'M', false),
        Student(15, "Nguyen Thi O", 20, 8.3f, 'F', true),
        Student(16, "Dinh Van P", 17, 5.5f, 'M', false),
        Student(17, "Le Thi Q", 22, 9.8f, 'F', true),
        Student(18, "Bui Van R", 18, 6.0f, 'M', false),
        Student(19, "Vu Thi S", 21, 8.1f, 'F', true),
        Student(20, "Hoang Van T", 19, 7.2f, 'M', false),
        Student(21, "Pham Thi U", 20, 9.4f, 'F', true),
        Student(22, "Tran Van V", 22, 5.8f, 'M', false),
        Student(23, "Le Thi W", 17, 7.9f, 'F', false),
        Student(24, "Ngo Van X", 23, 8.6f, 'M', true),
        Student(25, "Nguyen Thi Y", 18, 6.3f, 'F', false),
        Student(26, "Do Van Z", 21, 9.1f, 'M', true),
        Student(27, "Bui Thi AA", 20, 7.4f, 'F', false),
        Student(28, "Pham Van BB", 19, 8.7f, 'M', true),
        Student(29, "Tran Thi CC", 22, 6.1f, 'F', false),
        Student(30, "Vu Van DD", 17, 7.5f, 'M', false),
        Student(31, "Le Thi EE", 18, 9.0f, 'F', true),
        Student(32, "Nguyen Van FF", 23, 6.8f, 'M', false),
        Student(33, "Pham Thi GG", 21, 7.3f, 'F', false),
        Student(34, "Hoang Van HH", 20, 8.5f, 'M', true),
        Student(35, "Bui Thi II", 19, 5.7f, 'F', false),
        Student(36, "Tran Van JJ", 22, 9.9f, 'M', true),
        Student(37, "Ngo Thi KK", 17, 6.4f, 'F', false),
        Student(38, "Vu Van LL", 18, 7.1f, 'M', false),
        Student(39, "Le Thi MM", 21, 8.2f, 'F', true),
        Student(40, "Nguyen Van NN", 19, 5.9f, 'M', false),
        Student(41, "Pham Thi OO", 20, 9.3f, 'F', true),
        Student(42, "Do Van PP", 22, 6.5f, 'M', false),
        Student(43, "Bui Thi QQ", 17, 7.7f, 'F', false),
        Student(44, "Tran Van RR", 23, 8.4f, 'M', true),
        Student(45, "Le Thi SS", 18, 5.6f, 'F', false),
        Student(46, "Nguyen Van TT", 21, 9.6f, 'M', true),
        Student(47, "Pham Thi UU", 20, 6.6f, 'F', false),
        Student(48, "Hoang Van VV", 19, 7.0f, 'M', false),
        Student(49, "Bui Thi WW", 22, 9.1f, 'F', true),
        Student(50, "Tran Van XX", 23, 5.4f, 'M', false)
    )

    print("HELLO THIS IS STUDENT MANAGEMENT SYSTEM\n")
    print("=======================================\n")

    var classifiedListByAcademic: MutableMap<String, Int>

    while(true) {
        printHelpMenu()
        print("Enter your choice: ")
        val userChoice = readln().toIntOrNull()
        if (userChoice == null) {
            println("Invalid input! Please enter a NUMBER")
            continue
        }
        when(userChoice) {
            1 -> printStudentList(studentList)
            2 -> addStudent(studentList)
            3 -> printScholarshipStudentList(studentList)
            4 -> setGPAForAllStudent(studentList)
            5 -> setGPAByID(studentList)
            6 -> printStudentList(getStudentListWithDuplicateGPA(studentList))
            7 -> print(mapIDtoName(studentList))
            8 -> {
                for (student in studentList) {
                    print("Student name: ${student.name}, is classify as ${classificationByAge(student)}\n")
                }
            }
            9 -> {
                studentList.sortByDescending { it.gpa }
                printStudentList(studentList)
            }
            10 -> {
                classifiedListByAcademic = classifyByAcademicPerformance(studentList).toMutableMap()
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

fun printStudentInfor(student : Student) {
    print(
        "ID: ${student.id} - " +
                "Name: ${student.name} - " +
                "Age: ${student.age} - " +
                "GPA: ${student.gpa} - " +
                "Gender: ${student.gender} - " +
                "ScholarShip: ${student.scholarship}\n"
    )
}

fun printStudentList(studentList: List<Student>) {
    studentList.forEach { printStudentInfor(it) }
    print("\n====================================\n")
}

fun printScholarshipStudentList(studentList: List<Student>) {
    val scholarshipStudentList = studentList.filter { isEligibleForScholarship(it) }
    if(scholarshipStudentList.isEmpty()) {
        print("There is no student who is eligible for scholarship.")
    } else {
        print("List students who are eligible for a scholarship: \n")
        printStudentList(scholarshipStudentList)
    }
}

fun isEligibleForScholarship(student: Student): Boolean {
    return student.gpa >= MIN_SCHOLARSHIP_GPA
}

fun addStudent(studentList: MutableList<Student>) {
    print("Please enter all information\n")
    val id = enterID(studentList)
    val name = enterName()
    val age = enterAge()
    val gpa = enterGPA()
    val gender = enterGender()
    val scholarship = enterScholarship()
    studentList.add(Student(id, name, age, gpa, gender, scholarship))
}

fun setGPAForAllStudent(studentList: MutableList<Student>) {
    studentList.forEach { student ->
        print("$student\n")
        print("Please set the current student's GPA: \n")
        val gpa = enterGPA()
        student.gpa = gpa
        print("Updated student's infor: $student\n")
    }
}

fun setGPAByID(studentList: MutableList<Student>) {
    var validId = false
    while (!validId) {
        print("Id: ")
        val id = readln().toLongOrNull()
        if (id == null) {
            print("ID is a number, please enter a NUMBER\n")
            setGPAByID(studentList)
        }
        //val checkByIDResult = checkIfIdAlreadyExists(studentList, id!!)
        studentList.find {
            it.id == id
        }?.let{
            val gpa = enterGPA()
            it.gpa = gpa
            validId = true
        }?: run {
            println("There is no student with that id, please enter another id: ")
        }

//        if (checkByIDResult.first) {
//            val index = checkByIDResult.second
//            val gpa = enterGPA()
//            studentList[index].gpa = gpa
//            validId = true
//        } else {
//            println("There is no student with that id, please enter another id: ")
//        }
    }
}


fun enterID(studentList: List<Student>): Long {
    var id: Long? = null

    while (id == null || checkIfIdAlreadyExists(studentList, id).first) {
        print("Id: ")
        val input = readln().toLongOrNull()

        if (input == null) {
            println("ID must be a number, please enter a valid NUMBER")
        } else if (checkIfIdAlreadyExists(studentList, input).first) {
            println("This ID already exists, please enter a unique one")
        } else {
            id = input
        }
    }
    return id
}

fun enterName() : String {
    print("Name: ")
    val name = readln()
    return if(checkIfNameIsValid(name)) {
        print("This name is not validate, please enter another name\n")
        print("This name must be start with a letter and does not contain any special character or number\n")
        enterName()
    } else name
}

fun enterAge() : Int {
    print("Age: ")
    val age = readln().toIntOrNull()
    return if(age == null || age <= 0) {
        print("Age is not validate, please enter a correct one\n")
        enterAge()
    } else age
}

fun enterGPA() : Float {
    print("GPA (0.0 to 10.0): ")
    val gpa = readln().toFloatOrNull()
    return if(gpa == null || gpa > 10 || gpa < 0) {
        print("GPA must be a NUMBER between 0.0 and 10.0\n")
        enterGPA()
    } else gpa
}

fun enterGender() : Char {
    print("Gender (Male: M, Female: F): ")
    val gender =  readln().trim()
    return if(gender.isEmpty() || gender.length != 1 || gender[0] != 'M' && gender[0] != 'F') {
        print("Gender must be ONE CHARACTER ONLY: M (Male) or F (Female)\n")
        enterGender()
    } else gender[0]
}

fun enterScholarship() : Boolean {
    print("Scholarship (1 is true, 0 is false): ")
    val scholarship = readln().toIntOrNull()
    return if(scholarship != 1 && scholarship != 0) {
        print("Scholarship must be 1 (true) or 0 (false)\n")
        enterScholarship()
    } else if(scholarship == 1) true else false
}

fun checkIfIdAlreadyExists(studentList: List<Student>, id: Long) : Pair<Boolean, Int> {
    studentList.forEachIndexed { index, student ->
        if(student.id == id) {
            return Pair(true, index)
        }
    }
    return Pair(false, -1)
}

fun checkIfNameIsValid(name: String) : Boolean {
    //val regex = "^[A-Za-z]+([ A-Za-z]+)*$"
    return name.trim().isEmpty() || name.trim().contains(Regex("^[ A-Za-z]+\$")).not()
}

fun classificationByAge(student: Student) :String {
    return when {
        student.age < 18 -> ADOLESCENT
        student.age in 18..22 -> STUDENT
        else -> GRADUATE_OR_WORKING
    }
}

fun getStudentListWithDuplicateGPA(studentList: List<Student>) : List<Student> {
    val uniqueGPAList = mutableListOf<Float>()
    val duplicateGPAStudentList = mutableSetOf<Student>()
    studentList.forEach {
        if(uniqueGPAList.contains(it.gpa)) {
            duplicateGPAStudentList.add(it)
        } else {
            uniqueGPAList.add(it.gpa)
        }
    }
    return duplicateGPAStudentList.toList()
}

fun classifyByAcademicPerformance(studentList: List<Student>): Map<String, Int> {
    return studentList
        .groupBy {
            when {
                it.gpa >= 9.0 -> "Xuat sac"
                it.gpa >= 8.0 -> "Gioi"
                else -> "Kha"
            }
        }.mapValues { it.value.size }
}

fun mapIDtoName(studentList: List<Student>) : Map<Long, String> {
    return studentList.associate { it.id to it.name}
}
