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


interface IJobService{

findById(id) : Job throws JobNotFoundException


findAll(): Object[]


}

interface IITJobService{

addJob(id, type, language, experience ) : ITJob

findById(id): ITJob throws JobNotFoundException

findAll():ItJob[]

}



interface IElectronicsJobService {

addJob(id, type, device, experience ) : ElectronicsJob

findById(id): ElectronicsJob throws JobNotFoundException

findAll(): ElectronicsJob[]

}


abstract class  AbstractJobService{
// job array

addJob(job)

findJobById(id)

findAll(): Job[]


}
Concrete implementation classes
ITJobServiceImpl extends AbstractJobService  implements IITJobService{
....
}
ElectronicsJobServiceImpl extends AbstractJobService  implements IElectronicsJobService{
..
}
companyms
Company{

id: String

name: String


}                  
Features
Add job
find job by id
change job type
Validation
id : can't be zero or negative
name:  min length 2 , max 10
experience:  min 0 ,max 30
type: job type can be "electronics" or "it"
device: min 3 letter, max 10
language : min length 3 , max 8
Please Note
Fields should be private
Use getters setters