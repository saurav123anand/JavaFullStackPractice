base package com.traningapps.jobapp
subpackages :
jobms

companyms

ui               
jobms
Job{

id: long

type: String

company: Company

}


ITJob extends Job{

language: String

codingExperienceInYrs :int

}


ElectronicsJob extends Job{

deviceUsed: String

experienceWithDeviceInYrs: int

}


abstract BaseJobService{
//keep jobs array here

+addJob(Job job) : void

+findJobById(*) : Job

+findJobsByType(*) : Job[]
}

ITJobService extends BaseJobService{

+addJob(Job job) : void

+findJobById(*) : ITJob

+findJobsByType(*) : ITJob[]


}

ElectronsJobService extends BaseJobService{

+addJob(Job job) :

+findJobById(*) : ElectronicsJob

+findJobsByType(*) : ElectronicsJob[]

}
companyms
Company{

id: String

name: String


}                  
Features
Add employee
find employee by id
change department
Please Note
Fields should be private
Use getters setters