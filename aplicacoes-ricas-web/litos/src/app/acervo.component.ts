import { Component } from '@angular/core';
import { Livro } from './livro';
import { LivroDataService } from './livro-data.service';

@Component({
    selector: 'acervo',
    templateUrl: 'app/acervo.component.html',
    //styleUrls: ['app/acervo.component.css']
})
export class AcervoComponent {
  acervo: Livro[];

constructor(private livroDataService: LivroDataService) {

} 

  ngOnInit() {
     let livroDataService = new LivroDataService();
     this.acervo = this.livroDataService.getLivros();
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