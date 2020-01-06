import { Injectable } from '@angular/core';
import gql from "graphql-tag";
import {Apollo} from "apollo-angular";
import {Brand} from "../models/brand";
import {Car} from "../models/car";

const getAllQuery = gql`
  query cars {
    cars {
      id
      model
      year
      brand {
        name
      }
   }
  }
`;

const deleteMutation = gql`
   mutation deleteCar($id: ID!) {
    deleteCar(id: $id)
  }
`;

const createMutation = gql`
 mutation createCar($model: String!, $year: String!) {
    createCar(model: $model, year: $year) {
      id
      model
      year
    }
  }
`;

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private apollo: Apollo) { }

  getAll() {
    return this.apollo.watchQuery({
      query: getAllQuery
    }).valueChanges;
  }

  create(car: Car) {
    return this.apollo.mutate({
      mutation: createMutation,
      variables: {
        model: car.model,
        year: car.year
      },
      refetchQueries: ['cars']
    })
  }

  delete(id: any) {
    return this.apollo.mutate({
      mutation: deleteMutation,
      variables: {
        id: id
      },
      refetchQueries: ['cars']
    })
  }
}
