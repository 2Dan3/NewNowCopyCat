import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list.component';
import { LocationListComponent } from './location-list/location-list.component';

const routes: Routes = [
  
  {path: "events", component: EventListComponent},
  {path: "locations", component: LocationListComponent},
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
