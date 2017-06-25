import { Component } from '@angular/core';
import { Task } from './task';
import { TaskService } from './task.service';
import { TaskComponent } from './task.component';

@Component({
    selector: 'taskboard',
    templateUrl: 'app/taskboard.component.html',
    //styleUrls: ['app/acervo.component.css']
})
export class TaskBoardComponent {
  errorMessage: string;
  tasks: Task[];

    constructor(private taskService: TaskService) {
        this.tasks = [];
    } 

  ngOnInit() {
     this.getLivros();
  }

    getLivros(): void {
    this.taskService.getLivros()
    .then(tasks => { this.tasks = tasks })
    .catch( error => this.errorMessage = <any> error);
    }  
  /*getLivros(): void {
    this.livroDataService.getLivros()
    .subscribe(
        livros => this.acervo = livros,
        error => this.errorMessage = <any> error
    );
  }*/

  totalDeLivros() {
      let total = 0;
      /*for (let livro of this.acervo){
        total += livro.emEstoque;
      }*/
      return total;
  }

 adicionarUmNoCarrinho(livro:Task) {

     /*if (livro.quantidade < livro.emEstoque) {
         livro.quantidade++;
         livro.emEstoque--;
     }*/
 }

}