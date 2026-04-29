export class Event {
    _id: number;
    name: string;
    address: string;
    type: string;
    date: Date;
    price: number;
    recurrent: Boolean;

    locationAddress: string;

    constructor(eventObj?: any) {
        this._id = eventObj && eventObj.id || null;

        this.name = eventObj && eventObj.name || null;
        this.address = eventObj && eventObj.address || null;
        this.type = eventObj && eventObj.type || null;
        this.date = eventObj && new Date(eventObj.date).toLocaleDateString() || null;
        this.price = eventObj && eventObj.price || null;
        this.recurrent = eventObj && eventObj.recurrent || null;

        this.locationAddress = eventObj && eventObj.locationAddress || null;
    }
}