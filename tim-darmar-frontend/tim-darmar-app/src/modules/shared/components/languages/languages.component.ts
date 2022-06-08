import { AfterViewInit, Component, Input} from '@angular/core';
import { LanguageGlobally } from '../../models/LanguageGlobally';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.scss']
})
export class LanguagesComponent implements AfterViewInit{

  @Input() languages: LanguageGlobally[] = [];
  
  constructor() { }

  ngAfterViewInit(): void {

  }


}
