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

@NgModule({
  declarations: [
    AppComponent,
    CarComponent,
    BrandComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    GraphQLModule,
    MaterialModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
