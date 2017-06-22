import { Component } from '@angular/core';

@Component({
    selector: 'meu-app',
    template: `
      <nav>
        <div class="nav-wrapper">
          <a class="brand-logo">{{titulo}}</a>          
          <ul class="right">
            <li><a routerLink="/">Principal</a></li>
            <li><a routerLink="/sobre">Sobre</a></li>
          </ul>             
        </div>
      </nav>
      <div class="container">
        <router-outlet></router-outlet>        
      </div>`
})
export class AppComponent {
  titulo: string = "Livraria Litos";
}