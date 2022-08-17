inheritance task
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


JobStorage{

//keep jobs array here

+addITJob(*) : void

+addElectronicsJob(*) :void

+findJobById(*) :Job

+findJobsByType(*) : Job[]


}
companyms
Company{

id: String

name: String


}                  
Features
Add jobs
find job by id
find jobs by type
Please Note
Fields should be private
Use getters setters