import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app/app.component'; 
import { AcervoComponent } from './app/acervo.component'; 

@NgModule({
    declarations: [ AppComponent, AcervoComponent ],
    imports: [BrowserModule],
    bootstrap: [ AppComponent ]
})
class AppModule {
 
}
platformBrowserDynamic().bootstrapModule(AppModule);
 
