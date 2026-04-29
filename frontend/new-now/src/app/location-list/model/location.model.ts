export class Location {
    _id: number;
    name: string;
    description: string;
    created_at: Date;
    address: string;
    total_rating: number;
    type: string;
    image_path: string;

    constructor(obj?: any) {
        this._id = obj && obj.id || null;
        this.name = obj && obj.name || null;
        this.description = obj && obj.description || null;
        this.created_at = obj && new Date(obj.created_at).toLocaleDateString() || null;
        this.address = obj && obj.address || null;
        this.total_rating = obj && obj.total_rating || null;
        this.type = obj && obj.type || null;
        this.image_path = obj && obj.image_path || null;
    }
}