import { inject, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list.component';
import { LocationListComponent } from './location-list/location-list.component';
import { UsersListComponent } from './users-list/users-list.component';
import { AccountRequestsComponent } from './account-requests/account-requests.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminGuard } from './guards/admin/admin.guard';
import { AuthenticationGuard } from './guards/auth/authentication.guard';
import { AuthService } from './authService/auth.service';

const routes: Routes = [
  {path: "requests", component: AccountRequestsComponent, canActivate: [AdminGuard]},
  {path: "register", component: RegisterComponent},
  {path: "login", component: LoginComponent},
  {path: "profile", component: ProfileComponent, canActivate: [AuthenticationGuard]},

  {path: "", component: EventListComponent},
  // {path: "events/:id", component: EventOverviewComponent},
  {path: "locations", component: LocationListComponent},
  // {path: "locations/:id", component: LocationOverviewComponent},  
  {path: "users", component: UsersListComponent, canActivate: [() => inject(AuthService).isUserAdmin()]},
  // {path: "users", component: UsersListComponent},
  // {path: "users/:id", component: UserOverviewComponent},
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
