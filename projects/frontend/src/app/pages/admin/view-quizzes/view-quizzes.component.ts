import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quizzes',
  templateUrl: './view-quizzes.component.html',
  styleUrls: ['./view-quizzes.component.css']
})
export class ViewQuizzesComponent implements OnInit {
  quizzes=[];
  constructor(private quizService:QuizService) { }

  ngOnInit(): void {
    this.getQuizzes();
  }
  getQuizzes(){
    this.quizService.quizzes().subscribe(
      (data:any)=>{
         this.quizzes=data;
         console.log(this.quizzes)
      },
      error=>{
        Swal.fire('Error || ',"Error in loading data",'error')
      }

    )
  }

  //deleting quiz
  public deleteQuiz(quizId){
    this.quizService.deleteQuiz(quizId).subscribe(
      data=>{
        this.getQuizzes();
        Swal.fire("Success",'Quiz deleted','success')
      },
      error=>{
        Swal.fire("Error!!",'Error in deleting quiz','error')
      }
    )
  }

}
