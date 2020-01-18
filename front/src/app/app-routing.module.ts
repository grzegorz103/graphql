import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import * as path from "path";
import {CarComponent} from "./car/car.component";
import {BrandComponent} from "./brand/brand.component";
import {VehicleComponent} from "./vehicle/vehicle.component";


const routes: Routes = [
  {path: 'cars', component: CarComponent},
  {path: 'brands', component: BrandComponent},
  {path: 'vehicles', component: VehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
