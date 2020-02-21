import {Injectable} from '@angular/core';
import gql from "graphql-tag";
import {Apollo} from "apollo-angular";
import {Brand} from "../brand/brand";
import {Car} from "./car";

const getAllQuery = gql`
  query cars {
    cars {
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

const getByIdQuery = gql`
  query cars($id: ID!){
    carById(id: $id) {
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

const deleteMutation = gql`
   mutation deleteCar($id: ID!) {
    deleteCar(id: $id)
  }
`;

const createMutation = gql`
 mutation createCar($model: String!, $year: String!, $images: [String], $info: String!, $brandId: ID!) {
    createCar(model: $model, year: $year, images: $images, info: $info, brandId: $brandId) {
      id
      model
      year
      info
    }
  }
`;

const updateMutation = gql`
 mutation updateCar($id: ID!, $model: String!, $year: String!, $brandId: ID!) {
    updateCar(id: $id, model: $model, year: $year, brandId: $brandId) {
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

  constructor(private apollo: Apollo) {
  }

  getAll() {
    return this.apollo.watchQuery({
      query: getAllQuery
    }).valueChanges;
  }

  getById(id: any) {
    return this.apollo.watchQuery({
      query: getByIdQuery,
      variables: {
        id: id
      }
    }).valueChanges;
  }

  create(car: Car) {
    console.log(car.brand.id);
    return this.apollo.mutate({
      mutation: createMutation,
      variables: {
        model: car.model,
        year: car.year,
        images: car.images,
        info: car.info,
        brandId: car.brand.id
      },
      refetchQueries: ['cars']
    })
  }

  update(car: Car) {
    return this.apollo.mutate({
      mutation: updateMutation,
      variables: {
        id: car.id,
        model: car.model,
        year: car.year,
        brandId: car.brand.id
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
