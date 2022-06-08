import { Component, Input, OnInit } from '@angular/core';
import { Temp } from '../../models/Temp';

@Component({
  selector: 'app-areas',
  templateUrl: './areas.component.html',
  styleUrls: ['./areas.component.scss']
})
export class AreasComponent implements OnInit {

  
  @Input() tempExpertises: Temp[] = [];
  
  constructor() { }

  ngOnInit(): void {
    
  }

}
