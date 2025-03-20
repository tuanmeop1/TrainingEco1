package com.example.trainingeco1.extensions
import com.example.trainingeco1.model.Student

object StudentExtension {
    private fun printStudentInfo(student : Student) {
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
        studentList.forEach { printStudentInfo(it) }
        print("\n====================================\n")
    }

    fun printScholarshipStudentList(studentList: List<Student>) {
        val scholarshipStudentList = studentList.filter { it.isEligibleForScholarship() }
        if(scholarshipStudentList.isEmpty()) {
            print("There is no student who is eligible for scholarship.")
        } else {
            print("List students who are eligible for a scholarship: \n")
            printStudentList(scholarshipStudentList)
        }
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
                return
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

    //Updated
    private fun enterID(studentList: List<Student>): Long {
        while (true) {
            print("Id: ")
            val input = readln().toLongOrNull()

            when {
                input == null -> println("ID must be a number, please enter a valid NUMBER")
                studentList.any { it.id == input } -> println("This ID already exists, please enter a unique one")
                else -> return input
            }
        }
    }

    private fun enterName() : String {
        print("Name: ")
        val name = readln()
        return if(checkIfNameIsValid(name)) {
            print("This name is not validate, please enter another name\n")
            print("This name must be start with a letter and does not contain any special character or number\n")
            enterName()
        } else name
    }

    private fun enterAge() : Int {
        print("Age: ")
        val age = readln().toIntOrNull()
        return if(age == null || age < 0) {
            print("Age is not validate, please enter a correct one\n")
            enterAge()
        } else age
    }

    private fun enterGPA() : Float {
        print("GPA (0.0 to 10.0): ")
        val gpa = readln().toFloatOrNull()
        return if(gpa == null || gpa > 10 || gpa < 0) {
            print("GPA must be a NUMBER between 0.0 and 10.0\n")
            enterGPA()
        } else gpa
    }

    private fun enterGender() : Char {
        print("Gender (Male: M, Female: F): ")
        val gender =  readln().trim()
        return if(gender.isEmpty() || gender.length != 1 || gender[0] != 'M' && gender[0] != 'F') {
            print("Gender must be ONE CHARACTER ONLY: M (Male) or F (Female)\n")
            enterGender()
        } else gender[0]
    }

    private fun enterScholarship() : Boolean {
        print("Scholarship (1 is true, 0 is false): ")
        val scholarship = readln().toIntOrNull()
        //check
//    return if(scholarship != 1 && scholarship != 0) {
//        print("Scholarship must be 1 (true) or 0 (false)\n")
//        enterScholarship()
//    } else if(scholarship == 1) true else false
        return when(scholarship) {
            1 -> true
            0 -> false
            else -> {
                print("Scholarship must be 1 (true) or 0 (false)\n")
                enterScholarship()
            }
        }
    }

    private fun checkIfIdAlreadyExists(studentList: List<Student>, id: Long) : Pair<Boolean, Int> {
        studentList.forEachIndexed { index, student ->
            if(student.id == id) {
                return Pair(true, index)
            }
        }
        return Pair(false, -1)
    }

    private fun checkIfNameIsValid(name: String) : Boolean {
        //val regex = "^[A-Za-z]+([ A-Za-z]+)*$"
        return name.trim().isEmpty() || name.trim().contains(Regex("^[ A-Za-z]+\$")).not()
    }

    //Updated
    fun getStudentListWithDuplicateGPA(studentList: List<Student>) : List<Student> {
        return studentList.groupBy { it.gpa }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
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
}