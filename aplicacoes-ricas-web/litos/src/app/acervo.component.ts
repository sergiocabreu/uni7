import { Component } from '@angular/core';
import { Livro } from './livro';
import { ACERVO } from './livros.mocks';

@Component({
    selector: 'acervo',
    templateUrl: 'app/acervo.component.html',
    //styleUrls: ['app/acervo.component.css']
})
export class AcervoComponent {
  acervo: Livro[];

  ngOnInit() {
    this.acervo = ACERVO;
  }

  totalDeLivros() {
      let total = 0;
      for (let livro of this.acervo){
        total += livro.emEstoque;
      }
      return total;
  }

 adicionarUmNoCarrinho(livro:Livro) {
     console.log("quantidade" + livro.quantidade);
     console.log("estoque" + livro.emEstoque);

     if (livro.quantidade < livro.emEstoque) {
         livro.quantidade++;
         livro.emEstoque--;
     }

     console.log("quantidade" + livro.quantidade);
     console.log("estoque" + livro.emEstoque);
 }

}