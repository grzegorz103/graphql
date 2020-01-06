import {Component} from '@angular/core';
import {BrandService} from "./services/brand.service";
import {Subscription} from 'rxjs';
import {Apollo} from 'apollo-angular';
import gql from 'graphql-tag';
import {Brand} from "./models/brand";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "./services/car.service";
import {Car} from "./models/car";


const query = gql`
{
  brands{
    name
  }
}
`;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  brands: any[];
  private brand: Brand;
  cars: any[];
  private car: Car;

  constructor(private brandService: BrandService,
              private apollo: Apollo,
              private matSnackBar: MatSnackBar,
              private carService: CarService) {
    this.fetchBrands();
    this.fetchCars();
    this.brand = new Brand();
    this.car = new Car();
  }

  fetchBrands() {
    // @ts-ignore
    this.brandService.getAll().subscribe((res => this.brands = res.data.brands));
  }

  createBrand() {
    this.brandService.create(this.brand).subscribe(res => {
      this.matSnackBar.open('Dodano');
    })
  }

  updateBrand(id: any) {
    console.log(this.brands.find(e=>e.id===id));
    this.brandService.update(this.brands.find(e => e.id === id))
      .subscribe(res=>{
        this.matSnackBar.open('Zaktualizowano');
      });
  }

  deleteBrand(id: any) {
    this.brandService.delete(id).subscribe(res => {
      this.matSnackBar.open('Usunięto');
    })
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
