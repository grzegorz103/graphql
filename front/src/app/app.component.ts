import { Component } from '@angular/core';
import { BrandService } from "./brand.service";
import { Subscription } from 'rxjs';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';
import {Brand} from "./brand";


const query = gql`
{
  brands{
    name
  }
}
`;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front';
  brands: any[];
  private querySubscription: Subscription;
  private brand: Brand;

  constructor(private brandService: BrandService, private apollo: Apollo) {
    this.fetchBrands();
    this.brand = new Brand();
  }

  fetchBrands(){
    this.brandService.getAll().subscribe((res=>this.brands = res.data.brands));
  }

  create(){
    this.brandService.create(this.brand).subscribe(res=>{
      this.fetchBrands();
      alert("dodano");
    })
  }
}
