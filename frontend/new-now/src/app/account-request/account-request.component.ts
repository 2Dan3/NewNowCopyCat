import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AccountRequest } from '../account-requests/model/account-request.model';

@Component({
  selector: 'app-account-request',
  templateUrl: './account-request.component.html',
  styleUrls: ['./account-request.component.css']
})
export class AccountRequestComponent implements OnInit {

  @Input()
  _request!: AccountRequest;

  @Output()
  triggeredRequest! :EventEmitter<any>;

  constructor() {
    this.triggeredRequest = new EventEmitter();
   }

  ngOnInit(): void {
  }

  requestClick():void {
    this.triggeredRequest.emit(this._request);
  }

}
