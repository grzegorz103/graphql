import { Component, OnInit } from '@angular/core';
import {BrandService} from "../services/brand.service";
import {Apollo} from "apollo-angular";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "../services/car.service";
import {Brand} from "../models/brand";
import {Car} from "../models/car";

@Component({
  selector: 'app-brand',
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.scss']
})
export class BrandComponent implements OnInit {

  brands: any[];
  brand: Brand;

  constructor(private brandService: BrandService,
              private apollo: Apollo,
              private matSnackBar: MatSnackBar) {
    this.fetchBrands();
    this.brand = new Brand();
  }

  ngOnInit() {
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
}
