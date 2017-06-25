import { Component, Input } from '@angular/core'; 
import { ActivatedRoute, Router, Params } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import { TaskService } from './task.service';
import { Task } from './task';

@Component({     
    selector: 'tarefa',     
    templateUrl:  'app/tarefa.component.html' }) 
    export class TarefaComponent {      
        task: Task;

        constructor(private route: ActivatedRoute, private router: Router, private taskService: TaskService){
            this.task = {"id":0, "titulo":"", "descricao":"", "pontos":0, "tarefas":[]};
        }

        ngOnInit() {
            this.route.params
            // (+) converts string 'id' to a number
            .switchMap((params: Params) => this.taskService.getTask(+params['id']))
            .subscribe((product) => {
                this.task = product
            });
        }
    }