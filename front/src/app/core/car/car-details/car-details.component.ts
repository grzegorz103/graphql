import {Component, OnInit} from '@angular/core';
import {CarService} from "../car.service";
import {ActivatedRoute} from "@angular/router";
import {Car} from "../car";
import {Lightbox} from "ngx-lightbox";

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.scss']
})
export class CarDetailsComponent implements OnInit {

  car: Car;
  images = [];

  constructor(private carService: CarService,
              private _lightbox: Lightbox,
              private route: ActivatedRoute) {
    this.fetchCar();
  }

  ngOnInit() {
  }

  fetchCar() {
    this.carService.getById(this.route.snapshot.paramMap.get('id'))
      .subscribe(res => {
          // @ts-ignore
          this.car = res.data.carById;
          this.car.images.forEach(e => {
            this.images.push({
                src: e,
                thumb: e
              }
            )
          })
        }
      );
  }

  open(index: number): void {
    // open lightbox
    this._lightbox.open(this.images, index);
  }
}
