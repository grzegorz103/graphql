import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import * as path from "path";
import {CarComponent} from "./car/car.component";
import {BrandComponent} from "./brand/brand.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {CarDetailsComponent} from "./car-details/car-details.component";
import {MotorcycleComponent} from "./motorcycle/motorcycle.component";
import {ManageComponent} from "./manage/manage.component";
import {MotorcycleDetailsComponent} from "./motorcycle-details/motorcycle-details.component";


const routes: Routes = [
  {path: 'cars', component: CarComponent},
  {path: 'brands', component: BrandComponent},
  {path: 'vehicles', component: VehicleComponent},
  {path: 'cars/:id/details', component: CarDetailsComponent},
  {path: 'motorcycles', component: MotorcycleComponent},
  {path: 'motorcycles/:id/details', component: MotorcycleDetailsComponent},
  {path: 'manage', component: ManageComponent},
  {path: '**', component: VehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
