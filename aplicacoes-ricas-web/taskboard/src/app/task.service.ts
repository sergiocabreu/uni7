import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { Task } from './task'; 

@Injectable()
export class TaskService { 
    private apiLivros = 'http://localhost:3004/estorias';
    private apiLivro = 'http://localhost:3004/estorias/';

    constructor(private http: Http) { 

    }

    getTask(id:number): Promise<Task> {
        return this.http.get(this.apiLivro+id)
        .toPromise()
        .then(response =><Task> response.json())
        .catch(this.handleError);        
    }

    getLivros(): Promise<Task[]> {
        return this.http.get(this.apiLivros)
        .toPromise()
        .then(response => <Task[]>response.json())
        .catch(this.handleError);
    }
    /*getLivros() : Observable<Livro[]> {
        return this.http.get(this.apiLivros)
        .map(this.extrairDados)
        .catch(this.handleError);
    }*/

 private extrairDados(res: Response) {
    let body = <Task[]> res.json();
    return body || { };
 }

 private handleError(error: Response | any) {
    return Observable.throw(
    error.json().error || 'Erro no servidor');
 }

}   