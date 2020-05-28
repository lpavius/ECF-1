import { Component } from '@angular/core';
import { RegisterComponent } from './register/register.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'My mini Social Network';

  constructor() {
  }

  ngOnInit(): void {
  }

  loggedIn(): boolean {
    return sessionStorage.getItem('token') && sessionStorage.getItem('token').length !== 0;
  }
}
