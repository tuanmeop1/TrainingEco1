package com.example.trainingeco1.model

data class Student(val id: Long, val name: String, val age: Int,
                   var gpa: Float, val gender: Char,
                   var scholarship: Boolean) {

    companion object {
        const val MIN_SCHOLARSHIP_GPA = 8.0

        const val ADOLESCENT = "Vi thanh nien"
        const val STUDENT = "Sinh vien"
        const val GRADUATE_OR_WORKING = "Da tot nghiep hoac di lam"
    }

    init {
        scholarship = gpa > MIN_SCHOLARSHIP_GPA
    }

    constructor(id: Long, name: String, age: Int, gpa: Float, gender: Char) :
            this(id, name, age, gpa, gender, gpa > MIN_SCHOLARSHIP_GPA)

    fun isEligibleForScholarship(): Boolean {
        return gpa >= MIN_SCHOLARSHIP_GPA
    }

    fun classificationByAge() :String {
        return when {
            age < 18 -> ADOLESCENT
            age <= 22 -> STUDENT
            else -> GRADUATE_OR_WORKING
        }
    }
}
