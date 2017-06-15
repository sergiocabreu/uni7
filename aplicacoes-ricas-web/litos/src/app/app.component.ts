import { Component } from '@angular/core';

@Component({
    selector: 'meu-app',
    template: `
      <nav>
        <div class="nav-wrapper">
          <a class="brand-logo">{{titulo}}</a>          
        </div>
      </nav>
      <div class="container">
        <acervo></acervo>
      </div>`,
})
export class AppComponent {
  titulo: string = "Livraria Litos";
}