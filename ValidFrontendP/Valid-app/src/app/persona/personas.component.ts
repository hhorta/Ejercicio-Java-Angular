import { Component, OnInit } from '@angular/core';
import { Persona } from './persona';
import { PersonaService } from './persona.service';
import Swal from 'sweetalert2'
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html'
})
export class PersonasComponent implements OnInit {

  private persona: Persona = new Persona();
  personas: Persona[];
  errores: string[]=[];

  constructor(private personaService: PersonaService,private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.personaService.getPersonas().subscribe(
      personas => {this.personas = personas},
      errores => {this.errores = errores.status}
      
    );
  }

  cambiarEstado(){

    this.personaService.update(this.persona)
    .subscribe(
      json => {
        this.router.navigate(['/personas']);
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        })
      },
      err => {

        this.errores = this.errores;
        console.error('Código del error desde el backend: ' + err.status);
        console.error(err.error.errors);
      }
    )
  }
}
