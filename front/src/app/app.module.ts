import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphQLModule } from './graphql.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NavbarComponent} from "./shared/navbar/navbar.component";
import {MaterialModule} from "./material/material.module";
import {MDBBootstrapModule} from "angular-bootstrap-md";
import {FormsModule} from "@angular/forms";
import {CarComponent} from "./car/car-list/car.component";
import {BrandComponent} from "./brand/brand.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {CarDetailsComponent} from "./car/car-details/car-details.component";
import {LightboxModule} from "ngx-lightbox";
import {MotorcycleComponent} from "./motorcycle/motorcycle-list/motorcycle.component";
import {ManageComponent} from "./manage/manage.component";
import {FooterComponent} from "./footer/footer.component";
import {MotorcycleDetailsComponent} from "./motorcycle/motorcycle-details/motorcycle-details.component";

@NgModule({
  declarations: [
    AppComponent,
    CarComponent,
    BrandComponent,
    VehicleComponent,
    NavbarComponent,
    CarDetailsComponent,
    MotorcycleComponent,
    ManageComponent,
    FooterComponent,
    MotorcycleDetailsComponent
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
