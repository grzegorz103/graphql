import { Component, OnInit } from '@angular/core';
import {Lightbox} from "ngx-lightbox";
import {ActivatedRoute} from "@angular/router";
import {MotorcycleService} from "../motorcycle.service";
import {Motorcycle} from "../motorcycle";

@Component({
  selector: 'app-motorcycle-details',
  templateUrl: './motorcycle-details.component.html',
  styleUrls: ['./motorcycle-details.component.scss']
})
export class MotorcycleDetailsComponent implements OnInit {

  motorcycle: Motorcycle;
  images = [];

  constructor(private _lightbox: Lightbox,
              private route: ActivatedRoute,
              private motorcycleService: MotorcycleService) { }

  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.motorcycleService.getById(this.route.snapshot.paramMap.get('id'))
      .subscribe(res => {
          // @ts-ignore
          this.motorcycle = res.data.motorcycleById;
          this.motorcycle.images.forEach(e => {
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
