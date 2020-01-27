import {Component, OnInit} from '@angular/core';
import {Motorcycle} from "../models/motorcycle";
import {MotorcycleService} from "../services/motorcycle.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {

  motorcycle: Motorcycle = new Motorcycle();

  constructor(private motorcycleService: MotorcycleService,
              private matSnackBar: MatSnackBar) {
  }

  ngOnInit() {
  }

  createMotorcycle() {
    this.motorcycleService.create(this.motorcycle).subscribe(res => {
      this.matSnackBar.open('Dodano motocykl');
    })
  }
}
