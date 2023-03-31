import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../utils/helper';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  
  constructor(private http:HttpClient) { }

  public quizzes(){
    return this.http.get(`${baseUrl}/quiz/`)
  }

  //add quiz
  public addQuiz(quiz){
     return this.http.post(`${baseUrl}/quiz/`,quiz);
  }

  //delete quiz
  public deleteQuiz(quizId){
     return this.http.delete(`${baseUrl}/quiz/${quizId}`)
  }
}
