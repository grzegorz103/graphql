import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CoreRoutingModule} from './core-routing.module';
import {CarComponent} from "./car/car-list/car.component";
import {VehicleComponent} from "../shared/vehicle/vehicle.component";
import {CarDetailsComponent} from "./car/car-details/car-details.component";
import {MotorcycleComponent} from "./motorcycle/motorcycle-list/motorcycle.component";
import {MotorcycleDetailsComponent} from "./motorcycle/motorcycle-details/motorcycle-details.component";
import {ManageComponent} from "./manage/manage.component";
import {MaterialModule} from "../utils/material/material.module";
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "../app-routing.module";
import {FormsModule} from "@angular/forms";
import {GraphQLModule} from "../graphql.module";
import {LightboxModule} from "ngx-lightbox";
import {MDBBootstrapModule} from "angular-bootstrap-md";
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  declarations: [CarComponent,
    CarDetailsComponent,
    MotorcycleComponent,
    MotorcycleDetailsComponent,
    ManageComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    GraphQLModule,
    LightboxModule,
    MaterialModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    CoreRoutingModule
  ]
})
export class CoreModule {
}
