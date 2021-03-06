import {Component, OnInit} from '@angular/core';
import {MotorcycleService} from "../motorcycle.service";
import {Motorcycle} from "../motorcycle";
import {Brand} from "../../brand/brand";
import {BrandService} from "../../brand/brand.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-motorcycle',
  templateUrl: './motorcycle.component.html',
  styleUrls: ['./motorcycle.component.scss']
})
export class MotorcycleComponent implements OnInit {

  motorcycles: any;
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

}
