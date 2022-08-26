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

findById(id) : Job


findAll(): Object[]


}

interface IITJobService{

addJob(id, type, language, experience ) : ITJob

findById(id): ITJob

findAll():ItJob[]

}



interface IElectronicsJobService {

addJob(id, type, device, experience ) : ElectronicsJob

findById(id): ElectronicsJob

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
Please Note
Fields should be private
Use getters setters