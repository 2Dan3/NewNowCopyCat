import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from '../users-list/model/user.model';
import { ApiService } from '../apiService/api.service';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {

  _image_path_user :string= "";

  @Input()
  _user!: User;

  @Output()
  triggeredUser: EventEmitter<any>;

  constructor(
    private apiService: ApiService,

  )
  {
    this.triggeredUser = new EventEmitter();
  }

  ngOnInit(): void {
    this._image_path_user = `${this.apiService.getApiUrl()}/images/${this._user.avatar_path}`;
  }

  userClicked() {
    this.triggeredUser.emit(this._user);
  }

}
