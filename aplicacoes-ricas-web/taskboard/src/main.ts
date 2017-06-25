import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app/app.component';
import { TaskBoardComponent } from './app/taskboard.component';
import { FormsModule } from '@angular/forms'; 
import { TaskService } from './app/task.service';
import { RouterModule, Routes } from '@angular/router'; 
import { TarefaComponent } from './app/tarefa.component'; 
import { HttpModule } from '@angular/http';
import { TaskComponent } from './app/task.component';
const appRoutes: Routes = [ 
      { path: '', redirectTo: 'taskboard', pathMatch: 'full'},   
      { path: 'taskboard', component: TaskBoardComponent},
      { path: 'tarefas/:id', component: TarefaComponent }
]; 

@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, RouterModule.forRoot(appRoutes)],
    declarations: [ AppComponent,  TarefaComponent, TaskComponent, TaskBoardComponent ],
    bootstrap: [ AppComponent ],
    providers: [ TaskService ] 
})
class AppModule {}

platformBrowserDynamic().bootstrapModule(AppModule);