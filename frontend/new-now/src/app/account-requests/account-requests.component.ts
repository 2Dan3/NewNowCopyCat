import { Component, OnInit } from '@angular/core';
import { AccountRequest } from './model/account-request.model';
import { ApiService } from '../apiService/api.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-account-requests',
  templateUrl: './account-requests.component.html',
  styleUrls: ['./account-requests.component.css']
})
export class AccountRequestsComponent implements OnInit {

  _api_url_account_requests :string = "/requests";

  requests! :Array<AccountRequest>;
  apiService!: ApiService;

  constructor(
    apiService: ApiService,

  )
  {
    this.requests = [];
  }

  ngOnInit(): void {

    this.getAccountRequests()
      .subscribe(
          res => {
            for (const element of res) {
              this.requests.push(new AccountRequest(element));
            }
          }
        )
  }

  getAccountRequests() :Observable<any> {
    return this.apiService.get(this._api_url_account_requests);
  }

  apiCallRequest(objEvent: any) {
    console.log(objEvent);
    throw new Error("Not implemented!");
  }

}
