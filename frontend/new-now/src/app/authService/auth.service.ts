import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../apiService/api.service';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _role_admin = "ADMIN";

  constructor(
    private router: Router,
    private apiService: ApiService,
  ) { }


  login(user: any) {
    const loginHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });

    const body = {
      'username': user.username,
      'password': user.password
    };

    return this.apiService.post('/users/login', JSON.stringify(body), loginHeaders)
      .pipe(
        map( (res) => {
          // console.log("Login result: " + JSON.stringify(res));

          localStorage.setItem("jwt", res.body.accessToken);
          console.log("JWT from localStorage: " + localStorage.getItem("jwt"));
        }
        ));
  }

  register(user: any) {
    console.log(user);
    const registerHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    return this.apiService.post('/users/', JSON.stringify(user), registerHeaders)
      .pipe(
        map( 
          (res) => {
        console.log(res);
      }
      ));
  }
  

  isTokenPresent() : boolean {
    // throw new Error('Method not implemented.');
    return localStorage.getItem('jwt') != undefined && localStorage.getItem('jwt') != null;
  }

  getToken() {
    return localStorage.getItem('jwt');
    // throw new Error('Method not implemented.');
  }

  logout() {
    // this.userService.currentUser = null;
    localStorage.clear();
    window.alert("You have been signed out.");
    this.router.navigate(['/']);
  }

  isUserAdmin(): boolean {
  const token = this.getToken();
  if (token) {

    const payload = JSON.parse(atob(token.split('.')[1]));
    // console.log(token);
    // console.log(payload);
    // console.log("auth svc isUserAdmin: ", payload.role + this._role_admin);
    return payload.role.authority === this._role_admin;
  }
  return false;
}


}
