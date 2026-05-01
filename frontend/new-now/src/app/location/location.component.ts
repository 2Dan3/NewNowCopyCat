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
    _image_path: string = "";
    
  @Output()
  triggeredLocation :EventEmitter<any>;
  
  private _api_url: string = "/locations";


  constructor(
    private apiService: ApiService,
  ) 
  {
    this.triggeredLocation = new EventEmitter();
  }

  ngOnInit(): void {
    this._image_path = `${this.apiService.getApiUrl()}/images/${this._location.image_path}`;
  }


  trigger() {
    this.triggeredLocation.emit(this._location);
  }

}
