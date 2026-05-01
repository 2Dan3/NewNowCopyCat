import { Component, OnInit } from '@angular/core';
import { ApiService } from '../apiService/api.service';
import { User } from './model/user.model';
import { Observable, throwError } from 'rxjs';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users: Array<User>;
    
  private _api_url: string = "/users/all";

  constructor(
    private apiService: ApiService,
  )
  {
    this.users = [];
  }

  ngOnInit(): void {

    this.getUsers()
      .subscribe(
        res => {
          for (const element of res) {
            this.users.push(new User(element));
          }
        }
      )

  }


  private getUsers(): Observable<any> {
    return this.apiService.get(this._api_url);
  }

  apiCallUser(eventObj: User) {
    console.log(eventObj);
    throw new Error("Not implemented!");
  }

}
