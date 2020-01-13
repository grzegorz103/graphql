import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import * as path from "path";
import {CarComponent} from "./car/car.component";
import {BrandComponent} from "./brand/brand.component";


const routes: Routes = [
  {path: 'cars', component: CarComponent},
  {path: 'brands', component: BrandComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
