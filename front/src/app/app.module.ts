import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphQLModule } from './graphql.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NavbarComponent} from "./navbar/navbar.component";
import {MaterialModule} from "./material/material.module";
import {MDBBootstrapModule} from "angular-bootstrap-md";
import {FormsModule} from "@angular/forms";
import {CarComponent} from "./car/car.component";
import {BrandComponent} from "./brand/brand.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {CarDetailsComponent} from "./car-details/car-details.component";
import {LightboxModule} from "ngx-lightbox";
import {MotorcycleComponent} from "./motorcycle/motorcycle.component";
import {ManageComponent} from "./manage/manage.component";

@NgModule({
  declarations: [
    AppComponent,
    CarComponent,
    BrandComponent,
    VehicleComponent,
    NavbarComponent,
    CarDetailsComponent,
    MotorcycleComponent,
    ManageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    GraphQLModule,
    LightboxModule,
    MaterialModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
