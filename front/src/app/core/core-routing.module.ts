import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CarComponent} from "./car/car-list/car.component";
import {VehicleComponent} from "./vehicle/vehicle.component";
import {CarDetailsComponent} from "./car/car-details/car-details.component";
import {MotorcycleComponent} from "./motorcycle/motorcycle-list/motorcycle.component";
import {MotorcycleDetailsComponent} from "./motorcycle/motorcycle-details/motorcycle-details.component";
import {ManageComponent} from "./manage/manage.component";


const routes: Routes = [
  {path: 'cars', component: CarComponent},
  {path: 'vehicles', component: VehicleComponent},
  {path: 'cars/:id/details', component: CarDetailsComponent},
  {path: 'motorcycles', component: MotorcycleComponent},
  {path: 'motorcycles/:id/details', component: MotorcycleDetailsComponent},
  {path: 'manage', component: ManageComponent},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule {
}
