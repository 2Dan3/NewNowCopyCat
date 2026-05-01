import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../authService/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(
    // private authService :AuthService,
    private router: Router,
    protected authService: AuthService,
  ) { }

  ngOnInit(): void {
  }

  logout() {
    this.authService.logout();
  }

  protected toMyProfilePage() {
    this.router.navigate(['/profile']);
  }

  protected toHome(){
    this.router.navigate(['/']);
  }


}
