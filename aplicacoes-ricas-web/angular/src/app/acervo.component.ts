import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
 
@Component({
selector: 'acervo',
template: `
    <ul>
        <li *ngFor="let livro of acervo">
            <h2>{{livro.titulo}}</h2>
            <h3>{{livro.descricao | uppercase}}</h3>
            <p>{{livro.preco | currency: 'BRL': true}}</p>
            <p *ngIf="livro.emEstoque > 0">{{livro.emEstoque}} restantes</p>
            <p *ngIf="livro.emEstoque === 0">ESGOTADO</p>             
        </li>
    </ul>
    <p>Total de exemplares: {{totalDeLivros()}}</p> 
`
})
export class AcervoComponent {
    titulo: string = 'Livraria Lito';
    acervo = [
        {
        "id" : 1, 
        "titulo": "O Senhor dos Anéis",
        "descricao" : "Contos da Terra Média", 
        "preco": 100,
        "emEstoque" : 10
    }, 
      {
        "id" : 2, 
        "titulo": "Livro dos Sith",
        "descricao" : "A Ascensão do Livro dos Sith", 
        "preco": 100,
        "emEstoque" : 20
        }
    ]

totalDeLivros() {
    let total = 0;
    for (let livro of this.acervo){
        total += livro.emEstoque;
    }
 return total;
}
 
}