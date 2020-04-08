import { Component, OnInit } from '@angular/core';
import {Persona} from './persona'
import {PersonaService} from './persona.service'
import {Router, ActivatedRoute} from '@angular/router'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  public persona: Persona = new Persona()
  public titulo:string = "Crear Cliente"


  constructor(private personaService: PersonaService,
  private router: Router,
private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarPersona()
  }

  cargarPersona(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.personaService.getPersona(id).subscribe( (persona) => this.persona = persona)
      }
    })
  }

  create(
    
    procesado:boolean = false
  ): void {


    procesado=this.persona.procesado;
    this.personaService.create(this.persona)
      .subscribe(
       persona => {
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
         
          console.error('Código del error desde el backend: ' + err.status);
          if(err.status==500){
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Something went wrong!',
              footer: '<a href>Why do I have this issue?</a>'
            })
          }
         
        }
      );
  }

  update(
    procesadoV:boolean
    ):void{

    this.persona.procesado=procesadoV;
console.log("valor", procesadoV)
   // this.persona.procesado=procesadoVR;
    this.personaService.update(this.persona)
     .subscribe( Persona => {
       this.router.navigate(['/personas'])
       Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Your work has been saved',
        showConfirmButton: false,
        timer: 1500
      })
     }
 
     )
   
  }

}
