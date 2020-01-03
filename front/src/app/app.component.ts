import { Component } from '@angular/core';
import { BrandService } from "./brand.service";
import { Subscription } from 'rxjs';
import { Apollo } from 'apollo-angular';
import gql from 'graphql-tag';


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

  constructor(private brandService: BrandService, private apollo: Apollo) {
    this.querySubscription = this.apollo.query<any>({
      query: query
    })
      .subscribe(({ data, loading }) => {
        console.log(data);
       this.brands = data.brands;
      });
  }
}
