import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
 
@Component({
selector: 'meu-app',
template: `<h1>{{titulo}}</h1>
<acervo></acervo>
`
})
export class AppComponent {
    titulo: string = 'Livraria Lito';
}
 
 
