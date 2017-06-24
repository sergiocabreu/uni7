import { Component } from '@angular/core';
import { Livro } from './livro';
import { LivroDataService } from './livro-data.service';
import { LivroComponent } from './livro.component';

@Component({
    selector: 'acervo',
    templateUrl: 'app/acervo.component.html',
    //styleUrls: ['app/acervo.component.css']
})
export class AcervoComponent {
  errorMessage: string;
  acervo: Livro[];

    constructor(private livroDataService: LivroDataService) {
        this.acervo = [];
    } 

  ngOnInit() {
     this.getLivros();
  }

    getLivros(): void {
    this.livroDataService.getLivros()
    .then(livros => { this.acervo = livros })
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
      for (let livro of this.acervo){
        total += livro.emEstoque;
      }
      return total;
  }

 adicionarUmNoCarrinho(livro:Livro) {

     if (livro.quantidade < livro.emEstoque) {
         livro.quantidade++;
         livro.emEstoque--;
     }
 }

}