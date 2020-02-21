import {Component} from '@angular/core';
import {BrandService} from "./brand/brand.service";
import {Subscription} from 'rxjs';
import {Apollo} from 'apollo-angular';
import gql from 'graphql-tag';
import {Brand} from "./brand/brand";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "./car/car.service";
import {Car} from "./car/car";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Samochody';

  constructor() {
  }

}
