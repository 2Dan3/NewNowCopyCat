import { Component, Input, OnInit } from '@angular/core';
import { ApiService } from '../apiService/api.service';
import { Comment } from '../comment-list/model/comment.model';

@Component({
  selector: 'app-comment-card',
  templateUrl: './comment-card.component.html',
  styleUrls: ['./comment-card.component.css']
})
export class CommentCardComponent implements OnInit {

  _api_url: string = "/comments";
  apiService!: ApiService;

  @Input()
  _comment!: Comment;

  constructor(
    apiService: ApiService,
  ) 
  {
    
  }

  ngOnInit(): void {
  }

}
