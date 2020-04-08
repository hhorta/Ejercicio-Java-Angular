import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PersonasComponent } from './persona/personas.component';
import { FormComponent } from './persona/form.component';
import { PersonaService } from './persona/persona.service';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { registerLocaleData } from '@angular/common';
import localeES from '@angular/common/locales/es';

registerLocaleData(localeES, 'es');

const routes: Routes = [
  { path: '', redirectTo: '/personas', pathMatch: 'full' },
  { path: 'personas', component: PersonasComponent },
  { path: 'personas/form', component: FormComponent },
  { path: 'personas/form/:id', component: FormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
   
    PersonasComponent,
    FormComponent,
  
 
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [PersonaService, { provide: LOCALE_ID, useValue: 'es' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
