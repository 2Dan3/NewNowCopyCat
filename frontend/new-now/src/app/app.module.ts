import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EventListComponent } from './event-list/event-list.component';
import { EventCardComponent } from './event-card/event-card.component';
import { CommentListComponent } from './comment-list/comment-list.component';
import { CommentCardComponent } from './comment-card/comment-card.component';
import { ReviewCardComponent } from './review-card/review-card.component';
import { AddEditCommentComponent } from './add-edit-comment/add-edit-comment.component';
import { AddEditEventComponent } from './add-edit-event/add-edit-event.component';
import { UsersListComponent } from './users-list/users-list.component';
import { ReplyListComponent } from './reply-list/reply-list.component';
import { ProfileComponent } from './profile/profile.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AccountRequestComponent } from './account-request/account-request.component';
import { LocationListComponent } from './location-list/location-list.component';
import { LocationComponent } from './location/location.component';
import { TokenInterceptor } from './interceptor/token.interceptor';
import { HttpClientModule } from '@angular/common/http';
import { ReviewsComponent } from './reviews/reviews.component';
import { RatesComponent } from './rates/rates.component';
import { RateCardComponent } from './rate-card/rate-card.component';
import { UserCardComponent } from './user-card/user-card.component';
import { AccountRequestsComponent } from './account-requests/account-requests.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    EventListComponent,
    EventCardComponent,
    CommentListComponent,
    CommentCardComponent,
    ReviewCardComponent,
    AddEditCommentComponent,
    AddEditEventComponent,
    UsersListComponent,
    ReplyListComponent,
    ProfileComponent,
    AccountRequestComponent,
    LocationListComponent,
    LocationComponent,
    ReviewsComponent,
    RatesComponent,
    RateCardComponent,
    UserCardComponent,
    AccountRequestsComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, 
      useClass: TokenInterceptor, 
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
