import { Component, OnInit } from '@angular/core';
import {MotorcycleService} from "../services/motorcycle.service";

@Component({
  selector: 'app-motorcycle',
  templateUrl: './motorcycle.component.html',
  styleUrls: ['./motorcycle.component.scss']
})
export class MotorcycleComponent implements OnInit {

  motorcycles: any;

  constructor(private motorcycleService: MotorcycleService) { }

  ngOnInit() {
    this.fetchMotorcycles();
  }

  fetchMotorcycles(){
  // @ts-ignore
    this.motorcycleService.getAll().subscribe(res=>this.motorcycles = res.data.motorcycles);
  }
}
