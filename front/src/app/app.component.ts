import {Component} from '@angular/core';
import {BrandService} from "./brand.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  brands: any[];

  constructor(private brandService: BrandService) {
    this.brandService.getAll();
  //  this.brandService.getAll().subscribe(res => this.brands = res.data && res.data.brands);
  }
}
