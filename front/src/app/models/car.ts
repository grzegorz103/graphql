import {Brand} from "./brand";

export class Car{
  id: any;
  model: string;
  year: number;
  brand: Brand = new Brand();
}
