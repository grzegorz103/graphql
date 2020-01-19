import { Component, OnInit } from '@angular/core';
import {VehicleService} from "../services/vehicle.service";
import {BrandService} from "../services/brand.service";
import {Brand} from "../models/brand";

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.scss']
})
export class VehicleComponent implements OnInit {

  vehicles: any;
  brands: any;

  constructor(private vehicleService: VehicleService,
              private brandService: BrandService) {
    this.fetchBrands();
    this.fetchVehicles();
  }

  ngOnInit() {
  }

  fetchVehicles(){
    // @ts-ignore
    this.vehicleService.getAll().subscribe((res => this.vehicles = res.data.vehicles));
  }

  fetchBrands() {
    // @ts-ignore
    this.brandService.getAll().subscribe((res => this.brands = res.data.brands));
  }

  compareFn(c1: Brand, c2: Brand): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
