import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../authService/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private router: Router,
    private authService: AuthService,
    private formBuilder: FormBuilder 
  )
  {this.loginForm = this.formBuilder.group({
      "username": ['', Validators.compose([Validators.required, Validators.email])],
      "password": ['', Validators.compose([Validators.required])],
    });
  }

  ngOnInit(): void {
  }

  login() {
      // this.notification = undefined;
      // console.log("Entered login()!");
      
      // this.submitted = true;
      console.log("login() ", this.loginForm.value);
      this.authService.login(this.loginForm.value)
        .subscribe( 
          (res: any) => {
            console.log("successful Login!");
            this.router.navigate(['/']);
          },
          (_error: any) => {
            // this.submitted = false;
            console.log("Login error: " + JSON.stringify(_error));
            window.alert("Invalid username and/or password.");
            this.loginForm.reset();
            
            // this.notification = {msgType: 'error', msgBody: 'Incorrect username or password.'};
          });
  }
}
