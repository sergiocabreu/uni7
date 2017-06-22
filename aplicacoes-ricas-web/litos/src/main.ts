import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppComponent } from './app/app.component';
import { AcervoComponent } from './app/acervo.component';
import { FormsModule } from '@angular/forms'; 
import { LivroDataService } from './app/livro-data.service';
import { RouterModule, Routes } from '@angular/router'; 
import { SobrePageComponent } from './app/sobre-page.component'; 

const appRoutes: Routes = [ 
      { path: '', redirectTo: 'livros', pathMatch: 'full'},             
      { path: 'livros', component: AcervoComponent},             
      { path: 'sobre', component: SobrePageComponent }
]; 

@NgModule({
    imports: [BrowserModule, FormsModule, RouterModule.forRoot(appRoutes)],
    declarations: [ AppComponent, AcervoComponent ],
    bootstrap: [ AppComponent ],
     providers: [ LivroDataService ] 
})
class AppModule {}

platformBrowserDynamic().bootstrapModule(AppModule);