import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Event } from '../event-list/model/event.model';

@Component({
  selector: 'app-event-card',
  templateUrl: './event-card.component.html',
  styleUrls: ['./event-card.component.css']
})
export class EventCardComponent implements OnInit {

  @Input()
  _event! :Event;
  
  @Output()
  triggeredEvent :EventEmitter<any>;

  constructor(

  ) 
  {
    this.triggeredEvent = new EventEmitter();
  }

  ngOnInit(): void {
  }

  trigger() {
    this.triggeredEvent.emit(this._event);
  }

}
