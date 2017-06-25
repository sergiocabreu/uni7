import { Component, Input } from '@angular/core';
import { Task } from './task';

@Component({
    selector: 'task',
    templateUrl: 'app/task.component.html'
})
export class TaskComponent {
    @Input() task:Task;

    adicionarUmNoCarrinho(task: Task) {
        //this.acervoCompoAcervo.adicionarUmNoCarrinho(livro);
 }    
}