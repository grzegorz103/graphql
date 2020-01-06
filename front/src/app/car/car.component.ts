import { Component, OnInit } from '@angular/core';
import {BrandService} from "../services/brand.service";
import {Apollo} from "apollo-angular";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "../services/car.service";
import {Brand} from "../models/brand";
import {Car} from "../models/car";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.scss']
})
export class CarComponent implements OnInit {

  brands: any[];
  cars: any[];
  private car: Car;

  constructor(private brandService: BrandService,
              private apollo: Apollo,
              private matSnackBar: MatSnackBar,
              private carService: CarService) {
    this.fetchBrands();
    this.fetchCars();
    this.car = new Car();
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

  createCar() {
    this.carService.create(this.car).subscribe(res => {
      this.matSnackBar.open('Dodano samochód');
    })
  }

  compareFn(c1: Brand, c2: Brand): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
