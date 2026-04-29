import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from '../apiService/api.service';
import { Event } from './model/event.model';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  
  private _api_suffix = "/events";
  
  events!: Array<Event>;
  
  constructor(
    private apiService: ApiService,
  ) 
  {
    // this.events = [];
   }
   
  ngOnInit(): void {

    this.getEvents().subscribe(res => {
      this.events = [];

      for (const element of res) {
        this.events.push(new Event(element));
      }
    });
  }
  
  getEvents(): Observable<any> {
    return this.apiService.get(this._api_suffix);
  }
  
  protected apiCall(eventObj: Event) {
    
    console.log("apiCall event: ", eventObj._id, eventObj.name);
    throw new Error('Method not implemented.');
  }
}
