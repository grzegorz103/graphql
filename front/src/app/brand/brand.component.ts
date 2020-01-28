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
    this.brand = new Brand();
  }

  ngOnInit() {
  }


}
