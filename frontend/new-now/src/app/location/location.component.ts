import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Location } from '../location-list/model/location.model';
import { Review } from '../reviews/model/review.model';
import { ApiService } from '../apiService/api.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {

  @Input()
    _location! :Location;
    
  @Output()
  triggeredLocation :EventEmitter<any>;
  
  apiService!: ApiService;
  private _api_url: string = "/locations";


  constructor(
    apiService: ApiService,
  ) 
  {
    this.triggeredLocation = new EventEmitter();
  }

  ngOnInit(): void {
  }


  trigger() {
    this.triggeredLocation.emit(this._location);
  }

}
