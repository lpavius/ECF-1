import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NetworkService } from '../services/network.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  model: any;

  isValideFormSubmited = false;

  constructor(private http: HttpClient,
              private router: Router,
              private networkService: NetworkService) { }

  ngOnInit(): void {
    this.model = {};
    sessionStorage.setItem('token', '');
  }

  register() {
    this.isValideFormSubmited = false;
    this.networkService
      .register(this.model.email,
                this.model.firstname,
                this.model.lastname,
                this.model.birthdate,
                this.model.password)
      .subscribe(
        () => {
          let base64hash = btoa(this.model.email + ':' + this.model.password);
          sessionStorage.setItem('token', base64hash);
          this.isValideFormSubmited = true;
          this.router.navigate(['']);
        },
        error => {
          if (error.status === 401) {
            alert("Registration failed");
          }
        }
      );
  }

}
