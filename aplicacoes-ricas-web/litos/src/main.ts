import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app/app.component';
import { AcervoComponent } from './app/acervo.component';
import { FormsModule } from '@angular/forms'; 

@NgModule({
    imports: [BrowserModule, FormsModule],
    declarations: [ AppComponent, AcervoComponent ],
    bootstrap: [ AppComponent ]
})
class AppModule {}

platformBrowserDynamic().bootstrapModule(AppModule);