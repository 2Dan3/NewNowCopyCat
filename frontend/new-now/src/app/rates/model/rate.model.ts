export class Rate {
    _id: number;
    performance: number;
    sound_and_lighting: number;
    venue: number;
    overall_impression: number;

    constructor(obj?: any) {
        this._id = obj && obj.id || null;
        this.performance = obj && obj.performance || null;
        this.sound_and_lighting = obj && obj.sound_and_lighting || null;
        this.venue = obj && obj.venue || null;
        this.overall_impression = obj && obj.overall_impression || null;
    }
}