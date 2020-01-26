import {Brand} from "./brand";

export class Motorcycle {
  id: any;
  model: string;
  year: number;
  brand: Brand = new Brand();
  images: string[];
  info: string;

  constructor() {
    this.images = [];
    this.images.push('');
    this.images.push('');
    this.images.push('');
  }
}
