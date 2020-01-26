import {Component, OnInit} from '@angular/core';
import {MotorcycleService} from "../services/motorcycle.service";
import {Motorcycle} from "../models/motorcycle";
import {Brand} from "../models/brand";
import {BrandService} from "../services/brand.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-motorcycle',
  templateUrl: './motorcycle.component.html',
  styleUrls: ['./motorcycle.component.scss']
})
export class MotorcycleComponent implements OnInit {

  motorcycles: any;
  motorcycle: Motorcycle = new Motorcycle();
  brands: Brand[];

  constructor(private motorcycleService: MotorcycleService,
              private brandService: BrandService,
              private matSnackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.fetchMotorcycles();
    this.fetchBrands();
  }

  fetchMotorcycles() {
    // @ts-ignore
    this.motorcycleService.getAll().subscribe(res => this.motorcycles = res.data.motorcycles);
  }

  fetchBrands() {
    // @ts-ignore
    this.brandService.getAll().subscribe((res => this.brands = res.data.brands));
  }

  trackByIndex(index: number, obj: any): any {
    return index;
  }

  createMotorcycle() {
    this.motorcycleService.create(this.motorcycle).subscribe(res => {
      this.matSnackBar.open('Dodano motocykl');
    })
  }
}
