import {Component, OnInit} from '@angular/core';
import {Motorcycle} from "../models/motorcycle";
import {MotorcycleService} from "../services/motorcycle.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Car} from "../models/car";
import {BrandService} from "../services/brand.service";
import {CarService} from "../services/car.service";
import {Brand} from "../models/brand";

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {

  motorcycle: Motorcycle = new Motorcycle();
  car: Car = new Car();
  brands: any[];
  motorcycles: any[];
  cars: any[];

  constructor(private motorcycleService: MotorcycleService,
              private brandService: BrandService,
              private carService: CarService,
              private matSnackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchCars();
    this.fetchMotorcycles();
    this.fetchBrands();
  }

  fetchCars() {
    // @ts-ignore
    this.carService.getAll().subscribe(res => this.cars = res.data.cars);
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

  fetchMotorcycles() {
    // @ts-ignore
    this.motorcycleService.getAll().subscribe(res => this.motorcycles = res.data.motorcycles);
  }

  updateMotorcycles(id: any) {
  this.motorcycleService.update(this.motorcycles.find(e=>e.id === id))
    .subscribe(res=>{
      this.matSnackBar.open('Zaktualizowano');
    });
  }

  deleteMotorcycles(id: any) {
    this.motorcycleService.delete(id).subscribe(res => {
      this.matSnackBar.open('Usunięto')
    })
  }
}
