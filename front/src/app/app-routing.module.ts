import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import * as path from "path";
import {CarComponent} from "./car/car.component";
import {BrandComponent} from "./brand/brand.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {CarDetailsComponent} from "./car-details/car-details.component";
import {MotorcycleComponent} from "./motorcycle/motorcycle.component";
import {ManageComponent} from "./manage/manage.component";


const routes: Routes = [
  {path: 'cars', component: CarComponent},
  {path: 'brands', component: BrandComponent},
  {path: 'vehicles', component: VehicleComponent},
  {path: 'cars/:id/details', component: CarDetailsComponent},
  {path: 'motorcycles', component: MotorcycleComponent},
  {path: 'manage', component: ManageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
