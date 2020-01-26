import { Injectable } from '@angular/core';
import {Apollo} from "apollo-angular";
import gql from "graphql-tag";

const getAllQuery = gql`
  query motorcycles {
    motorcycles {
      id
      model
      year
      info
      brand {
        id
        name
      }
      images
   }
  }
`;

@Injectable({
  providedIn: 'root'
})
export class MotorcycleService {

  constructor(private apollo: Apollo) {
  }

  getAll() {
    return this.apollo.watchQuery({
      query: getAllQuery
    }).valueChanges;
  }

}
