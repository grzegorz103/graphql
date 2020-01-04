import { Injectable } from '@angular/core';
import { Apollo } from "apollo-angular";
import gql from "graphql-tag";
import {Brand} from "./brand";

const getAllQuery = gql`
  {
    brands {
      id
      name
   }
  }
`;

const createMutation = gql`
 mutation createBrand($name: String!) {
    createBrand(name: $name) {
      id
      name
    }
  }
`;

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private apollo: Apollo) {
  }

  getAll() {
    return this.apollo.query<any>({
      query: getAllQuery
    })
  }

  create(brand: Brand){
    return this.apollo.mutate({
      mutation: createMutation,
      variables: {
        name: brand.name
      }
    })
  }

}
