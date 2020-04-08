import { Injectable } from '@angular/core';
import { Persona } from './persona';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable()
export class PersonaService {
  private urlEndPoint: string = 'http://localhost:8080/valid/persona';
  private proceso: string = 'procesado'
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient) { }

  getPersonas(): Observable<Persona[]> {
    
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Persona[])
    );
  }

  create(persona: Persona) : Observable<Persona> {
    return this.http.post<Persona>(this.urlEndPoint, persona, {headers: this.httpHeaders})
  }

  getPersona(id): Observable<Persona>{
    return this.http.get<Persona>(`${this.urlEndPoint}/${id}`)
  }

  update(persona: Persona): Observable<Persona>{
    return this.http.patch<Persona>(`${this.urlEndPoint}/${persona.id}/${this.proceso}/${persona.procesado}`, persona, {headers: this.httpHeaders})
    
  }



}
