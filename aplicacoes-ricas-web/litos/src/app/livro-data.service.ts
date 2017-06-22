import { ACERVO } from './livros.mocks'; 
import { Injectable } from '@angular/core';

@Injectable()
export class LivroDataService { 
     getLivros() {     
         return ACERVO;   
     }
}