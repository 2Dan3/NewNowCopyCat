import { Component, Input, OnInit } from '@angular/core';
import { ApiService } from '../apiService/api.service';
import { Review } from '../reviews/model/review.model';
import { Rate } from '../rates/model/rate.model';

@Component({
  selector: 'app-rate-card',
  templateUrl: './rate-card.component.html',
  styleUrls: ['./rate-card.component.css']
})
export class RateCardComponent implements OnInit {

  _api_url :string = "/rates";
  
  apiService!: ApiService;

  @Input()
  _review!: Review;
  @Input()
  _rate!: Rate;

  constructor(
    apiService: ApiService,
  )
  {

  }

  ngOnInit(): void {
  }

}
