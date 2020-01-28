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

const deleteMutation = gql`
   mutation deleteMotorcycle($id: ID!) {
    deleteMotorcycle(id: $id)
  }
`;

const updateMutation = gql`
 mutation updateMotorcycle($id: ID!, $model: String!, $year: String!, $brandId: ID!) {
    updateMotorcycle(id: $id, model: $model, year: $year, brandId: $brandId) {
      id
      model
      year
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

  delete(id: any) {
    return this.apollo.mutate({
      mutation: deleteMutation,
      variables: {
        id: id
      },
      refetchQueries: ['motorcycles']
    })
  }

  update(motorcycle: Motorcycle) {
    return this.apollo.mutate({
      mutation: updateMutation,
      variables: {
        id: motorcycle.id,
        model: motorcycle.model,
        year: motorcycle.year,
        brandId: motorcycle.brand.id
      },
      refetchQueries: ['motorcycles']
    })
  }

  getById(id: string) {

  }
}
