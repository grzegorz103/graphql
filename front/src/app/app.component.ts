import {Component} from '@angular/core';
import {BrandService} from "./services/brand.service";
import {Subscription} from 'rxjs';
import {Apollo} from 'apollo-angular';
import gql from 'graphql-tag';
import {Brand} from "./models/brand";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CarService} from "./services/car.service";
import {Car} from "./models/car";

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
