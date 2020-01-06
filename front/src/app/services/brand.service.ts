import {Injectable} from '@angular/core';
import {Apollo} from "apollo-angular";
import gql from "graphql-tag";
import {Brand} from "../models/brand";

const getAllQuery = gql`
  query brands {
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

const deleteMutation = gql`
   mutation deleteBrand($id: ID!) {
    deleteBrand(id: $id)
  }
`;

const updateMutation = gql`
 mutation updateBrand($id: ID!, $name: String!) {
    updateBrand(id: $id, name: $name) {
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
    return this.apollo.watchQuery({
      query: getAllQuery
    }).valueChanges;
  }

  create(brand: Brand) {
    return this.apollo.mutate({
      mutation: createMutation,
      variables: {
        name: brand.name
      },
      refetchQueries: ['brands']
    })
  }

  update(brand:Brand){
    return this.apollo.mutate({
      mutation: updateMutation,
      variables: {
        id: brand.id,
        name: brand.name
      },
      refetchQueries: ['brands']
    })
  }
  delete(id: any) {
    return this.apollo.mutate({
      mutation: deleteMutation,
      variables: {
        id: id
      },
      refetchQueries: ['brands']
    })
  }
}
