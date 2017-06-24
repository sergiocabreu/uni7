import { ACERVO } from './livros.mocks'; 
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { Livro } from './livro'; 

@Injectable()
export class LivroDataService { 
    private apiLivros = 'http://localhost:3004/livros';

    constructor(private http: Http) { 

    }

    getLivros(): Promise<Livro[]> {
        return this.http.get(this.apiLivros)
        .toPromise()
        .then(response => <Livro[]>response.json())
        .catch(this.handleError);
    }
    /*getLivros() : Observable<Livro[]> {
        return this.http.get(this.apiLivros)
        .map(this.extrairDados)
        .catch(this.handleError);
    }*/

 private extrairDados(res: Response) {
    let body = <Livro[]> res.json();
    return body || { };
 }

 private handleError(error: Response | any) {
    return Observable.throw(
    error.json().error || 'Erro no servidor');
 }

}   