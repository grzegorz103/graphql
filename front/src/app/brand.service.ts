import { Injectable } from '@angular/core';
import { Apollo } from "apollo-angular";
import gql from "graphql-tag";

const getAllQuery = gql`
  {
    brands {
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

}
