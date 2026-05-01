export class AccountRequest {
    _id: number;
    email: string;
    password: string;
    address: string;

    constructor(obj? :any) {
        this._id = obj && obj.id;
        this.email = obj && obj.email;
        this.password = obj && obj.password;
        this.address = obj && obj.address;
    }
}
