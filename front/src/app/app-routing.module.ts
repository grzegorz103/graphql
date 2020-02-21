import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import * as path from "path";
import {CarComponent} from "./core/car/car-list/car.component";
import {VehicleComponent} from "./shared/vehicle/vehicle.component";
import {CarDetailsComponent} from "./core/car/car-details/car-details.component";
import {MotorcycleComponent} from "./core/motorcycle/motorcycle-list/motorcycle.component";
import {ManageComponent} from "./core/manage/manage.component";
import {MotorcycleDetailsComponent} from "./core/motorcycle/motorcycle-details/motorcycle-details.component";
import {NavbarComponent} from "./shared/navbar/navbar.component";


const routes: Routes = [
  {path: 'core', loadChildren: () => import('./core/core.module').then(m => m.CoreModule)},
  {path: '**', component: VehicleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
