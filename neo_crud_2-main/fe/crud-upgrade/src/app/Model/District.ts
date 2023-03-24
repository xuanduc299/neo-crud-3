export class District {
    id: number;
    name: string;
    provinceId: number;
    village: any;
    constructor(id: number, name: string, provinceId: number, village: any) {
        this.id = id;
        this.name = name;
        this.provinceId = provinceId;
        this.village = village;
    }
}