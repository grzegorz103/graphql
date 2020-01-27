import { Component, OnInit } from '@angular/core';
import {BrandService} from "../services/brand.service";
import {Apollo} from "apollo-angular";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "../services/car.service";
import {Brand} from "../models/brand";
import {Car} from "../models/car";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.scss']
})
export class CarComponent implements OnInit {

  brands: any[];
  cars: any[];

  constructor(private brandService: BrandService,
              private apollo: Apollo,private _sanitizer: DomSanitizer,
              private matSnackBar: MatSnackBar,
              private carService: CarService) {
    this.fetchBrands();
    this.fetchCars();
  }

  ngOnInit() {
  }

  fetchBrands() {
    // @ts-ignore
    this.brandService.getAll().subscribe((res => this.brands = res.data.brands));
  }

  fetchCars() {
    // @ts-ignore
    this.carService.getAll().subscribe(res => this.cars = res.data.cars);
  }

  updateCar(id: any) {
    console.log(this.cars.find(e=>e.id===id));
    this.carService.update(this.cars.find(e => e.id === id))
      .subscribe(res=>{
        this.matSnackBar.open('Zaktualizowano');
      });
  }

  deleteCar(id: any) {
    this.carService.delete(id).subscribe(res => {
      this.matSnackBar.open('Usunięto')
    })
  }

  compareFn(c1: Brand, c2: Brand): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  getBackground(image) {
    return this._sanitizer.bypassSecurityTrustStyle(`linear-gradient(rgba(29, 29, 29, 0), rgba(16, 16, 23, 0.5)), url(${image})`);
  }
}
