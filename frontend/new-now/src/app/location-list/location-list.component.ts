import { Component, OnInit } from '@angular/core';
import { ApiService } from '../apiService/api.service';
import { Location } from './model/location.model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-location-list',
  templateUrl: './location-list.component.html',
  styleUrls: ['./location-list.component.css']
})
export class LocationListComponent implements OnInit {

  private _api_suffix = "/locations";
    
    locations!: Array<Location>;
    
    constructor(
      private apiService: ApiService,
    ) 
    {
      this.locations = [];
     }
     
    ngOnInit(): void {
  
      this.getLocations().subscribe(res => {
        // this.locations = [];
  
        for (const element of res) {
          this.locations.push(new Location(element));
        }
      });
    }
    
    getLocations(): Observable<any> {
      return this.apiService.get(this._api_suffix);
    }
    
    protected apiCall(eventObj: Location) {
      
      console.log("apiCall Location event: ", eventObj._id, eventObj.name);
      throw new Error('Method not implemented.');
    }
}
