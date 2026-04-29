import { Comment } from "../../comment-list/model/comment.model";
import { Event } from "../../event-list/model/event.model";
import { Location } from "../../location-list/model/location.model";
import { Rate } from "../../rates/model/rate.model";
import { User } from "../../users-list/model/user.model";

export class Review {
    _id: number;
    created_at: Date;
    event_count: number;
    hidden: boolean;
    
    rate: Rate;
    location: Location;
    event: Event;
    comment: Comment;
    user: User;

    constructor(obj?: any) {
        this._id = obj && obj.id || null;
        this.created_at = obj && new Date(obj.created_at).toLocaleDateString() || null;
        this.event_count = obj && obj.event_count || null;
        this.hidden = obj && obj.hidden || null;
        this.rate = obj && new Rate(obj.rate) || null;
        this.location = obj && new Location(obj.location) || null;
        this.event = obj && new Event(obj.event) || null;
        this.comment = obj && new Comment(obj.comment) || null;
        this.user = obj && new User(obj.user) || null;
    }
}