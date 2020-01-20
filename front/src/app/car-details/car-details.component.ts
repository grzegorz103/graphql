import {Component, OnInit} from '@angular/core';
import {CarService} from "../services/car.service";
import {ActivatedRoute} from "@angular/router";
import {Car} from "../models/car";

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.scss']
})
export class CarDetailsComponent implements OnInit {

  car: Car;

  constructor(private carService: CarService,
              private route: ActivatedRoute) {
    this.fetchCar();
  }

  ngOnInit() {
  }

  fetchCar() {
    this.carService.getById(this.route.snapshot.paramMap.get('id'))
      .subscribe(res => {
        // @ts-ignore
        this.car = res.data.carById
      });
  }
}
