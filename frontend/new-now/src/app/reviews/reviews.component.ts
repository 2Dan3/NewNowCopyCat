import { Component, Input, OnInit } from '@angular/core';
import { Location } from '../location-list/model/location.model';
import { ApiService } from '../apiService/api.service';
import { Review } from './model/review.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {

  reviews!: Array<Review>;
  
  private _api_url: string = "/reviews";
  
  apiService!: ApiService;
  
  @Input()
  _location!: Location;

  constructor(
    apiService: ApiService
  )
  {
    this.reviews = [];
  }

  ngOnInit(): void {

    this.getReviews(this._location._id)
          .subscribe(
            res => {
              for (const element of res) {
                this.reviews.push(new Review(element));
              }
            }
        )
  }

  private getReviews(locationID: number): Observable<any> {
    return this.apiService.get(`${this._api_url}?location_id=${locationID}`);
  }

}
