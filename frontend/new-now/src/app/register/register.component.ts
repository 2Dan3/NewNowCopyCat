import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../authService/auth.service';

// interface DisplayMessage{
//     msgType: string;
//     msgBody: string;
// }

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  registerForm :FormGroup;

  submitted = false;

  // notification: DisplayMessage;

  constructor(
    // private userService: UserService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) 
  {
    this.registerForm = this.formBuilder.group({
      "email": ['', Validators.compose([Validators.required, Validators.email])],
      "password": ['', Validators.compose([Validators.required, Validators.minLength(8)])],
      "address": ['', Validators.compose([Validators.required])]
    });
  }

  ngOnInit(): void {
    
  }

  onSubmit(){
    // this.notification = undefined;
    console.log("Entered onSubmit()!");
    // if (document.getElementById("pw")?.innerText == document.getElementById("repeated-pw")?.innerText) {
    //   window.alert("Passwords do not match!");
    //   console.log("Passwords do not match!");
    // }
    this.submitted = true;

    this.authService.register(this.registerForm.value)
      .subscribe( 
        (res: any) => {
          // console.log("response status;" + res['status']);
          // this.userService.getMyInfo().subscribe();
          // if (res['status'] == 201){
            window.alert("You have successfully registered.");
            this.router.navigate(['/login']);
          // }
        },
        (_error: HttpErrorResponse) => {
          this.submitted = false;
          console.log("Error caught;" + _error, "status" + _error.status);
          if (_error.status == 406) {
            window.alert("Username and/or email you entered were already taken. Try another one!");
          }
          if (_error.status == 400) {
            window.alert("The Email you entered isn't in valid format.")
          }
          this.registerForm.reset();
          // this.notification = {msgType: 'error', msgBody: 'Incorrect username or password.'};
        });
  }


  private buildForm() {
    this.registerForm = this.formBuilder.group({
      "email": ['', Validators.compose([Validators.required, Validators.email])],
      "password": ['', Validators.compose([Validators.required])],
      "address": ['', Validators.compose([Validators.required])]
    });
  }

}