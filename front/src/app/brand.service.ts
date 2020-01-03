import { Injectable } from '@angular/core';
import { Apollo } from "apollo-angular";
import gql from "graphql-tag";

type Brand = {
  id: string;
  name: string;
}

type Response = {
  brands: Brand[];
}

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(
    private apollo: Apollo
  ) {
  }


}
