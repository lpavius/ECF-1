import { Injectable } from '@angular/core';
import { Observer, Observable } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class NetworkService {

  port: number = 8083;

  constructor(private http: HttpClient) { }

  public register(email: string,
    firstname: string,
    lastname: string,
    birthdate: Date,
    password: string): Observable<any> {
      return this.http
      .post(`http://localhost:${this.port}/user`, {
        email: email,
        firstName: firstname,
        lastName: lastname,
        birthDate: birthdate,
        password: password
      });
    }
}
