import {Component, OnInit} from '@angular/core';
import {Motorcycle} from "../models/motorcycle";
import {MotorcycleService} from "../services/motorcycle.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Car} from "../models/car";
import {BrandService} from "../services/brand.service";
import {CarService} from "../services/car.service";

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {

  motorcycle: Motorcycle = new Motorcycle();
  car: Car = new Car();
  brands: any[];

  constructor(private motorcycleService: MotorcycleService,
              private brandService: BrandService,
              private carService: CarService,
              private matSnackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchBrands();
  }

  fetchBrands() {
    // @ts-ignore
    this.brandService.getAll().subscribe((res => this.brands = res.data.brands));
  }

  createMotorcycle() {
    this.motorcycleService.create(this.motorcycle).subscribe(res => {
      this.matSnackBar.open('Dodano motocykl');
    })
  }

  createCar() {
    this.carService.create(this.car).subscribe(res => {
      this.matSnackBar.open('Dodano samochód');
    })
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }
}
