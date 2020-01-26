import { Injectable } from '@angular/core';
import {Apollo} from "apollo-angular";
import gql from "graphql-tag";
import {Motorcycle} from "../models/motorcycle";

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

const createMutation = gql`
 mutation createMotorcycle($model: String!, $year: String!, $images: [String], $info: String!, $brandId: ID!) {
    createMotorcycle(model: $model, year: $year, images: $images, info: $info, brandId: $brandId) {
      id
      model
      year
      info
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


  create(motorcycle: Motorcycle) {
    return this.apollo.mutate({
      mutation: createMutation,
      variables: {
        model: motorcycle.model,
        year: motorcycle.year,
        images: motorcycle.images,
        info: motorcycle.info,
        brandId: motorcycle.brand.id
      },
      refetchQueries: ['motorcycles']
    })
  }
}
