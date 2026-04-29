import { Event } from "../../event-list/model/event.model";
import { Location } from "../../location-list/model/location.model";
import { Rate } from "../../rates/model/rate.model";
import { Review } from "../../reviews/model/review.model";
import { User } from "../../users-list/model/user.model";

export class Comment {
    _id: number;
    text: string;
    created_at: Date;
    hidden: Boolean;

    rate: Rate;
    user: User;
    event: Event;
    location: Location;
    parent_comment_id: number;
    // review: Review;

    constructor(obj?: any) {
        this._id = obj && obj.id || null;
        this.text = obj && obj.text || null;
        this.created_at = obj && new Date(obj.created_at).toLocaleDateString() || null;
        this.hidden = obj && obj.hidden || false;

        this.rate = obj && new Rate(obj.rate) || null;
        this.user = obj && new User(obj.user) || null;
        this.event = obj && new Event(obj.event) || null;
        this.location = obj && new Location(obj.location) || null;
        this.parent_comment_id = obj && obj.parentCommentId || null;
        // this.review = obj && new Review(obj.review) || null;
    }
}