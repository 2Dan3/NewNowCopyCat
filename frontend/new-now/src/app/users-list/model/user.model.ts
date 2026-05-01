export class User {
    _id: number;
    email: string;
    password: string;
    name: string;
    created_at: Date;
    phone_number: string;
    birthday: Date;
    address: string;
    city: string;

    role: string;
    avatar_path: string;

    constructor(obj?: any) {
        this._id = obj && obj.id || null;
        this.email = obj && obj.email || null;
        this.password = obj && obj.password || null;
        this.name = obj && obj.name || null;
        this.created_at = obj && new Date(obj.created_at).toLocaleDateString() || null;
        this.phone_number = obj && obj.phone_number || null;
        this.birthday = obj && new Date(obj.birthday).toLocaleDateString() || null;
        this.address = obj && obj.address || null;
        this.city = obj && obj.city || null;

        this.role = obj && obj.role || null;
        this.avatar_path = obj && obj.avatar_path || null;
    }
}