import { Component, Input, OnInit } from '@angular/core';
import { ApiService } from '../apiService/api.service';
import { Review } from '../reviews/model/review.model';
import { Location } from '../location-list/model/location.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})
export class ReviewCardComponent implements OnInit {

  reviews!: Array<Review>;
  
  private _api_url: string = "/reviews";
  
  @Input()
  _location!: Location;
  
  @Input()
  _review!: Review;
  

  constructor(
    private apiService: ApiService,
  ) 
  {
    this.reviews = [];
  }

  ngOnInit(): void { }

  editReview(body: Review) {
    this.apiService.put(this._api_url, body);
    // .subscribe;
  }

}
