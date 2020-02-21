import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from "./navbar/navbar.component";
import {FooterComponent} from "./footer/footer.component";
import {RouterModule} from "@angular/router";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {MaterialModule} from "../utils/material/material.module";


@NgModule({
  declarations: [
    NavbarComponent,
    VehicleComponent,
    FooterComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MaterialModule
  ],
  exports:[
    NavbarComponent,
    VehicleComponent,
    FooterComponent
  ]
})
export class SharedModule {
}
