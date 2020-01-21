import { Injectable } from '@angular/core';
import gql from "graphql-tag";
import {Apollo} from "apollo-angular";

const getAllQuery = gql`
  query vehicles {
    vehicles {
      id
      model
      year
      images
      subType
   }
  }
`;

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private apollo: Apollo) { }

  getAll() {
    return this.apollo.watchQuery({
      query: getAllQuery
    }).valueChanges;
  }
}
