base package com.traningapps.studentapp
subpackages :
studentms

departmentms
ui               
studentms

Student{

id: long

name: String

department: Department

}


CseStudent extends Student{

language: String

codingExperienceInYrs :int

}


EceStudent extends Student{

deviceUsed: String

experienceWithDeviceInYrs: int

}


abstract BaseStudentService{
//keep jobs array here

+addStudent(Student student) : void

+findStudentById(*) : Student

+findStudentsByType(*) : Student[]
}

CseStudentService extends BaseStudentService{

+addStudent(Student student) : void

+findStudentById(*) : CseStudent

+findStudentsByType(*) : CseStudent[]


}

EceStudentService extends BaseStudentService{

+addStudent(Student student) : void

+findStudentById(*) : EceStudent

+findStudentsByType(*) : EceStudent[]

}
companyms
Department{

id: String

name: String


}                  
Features
Add student
find student by id
change department
Please Note
Fields should be private
Use getters setters