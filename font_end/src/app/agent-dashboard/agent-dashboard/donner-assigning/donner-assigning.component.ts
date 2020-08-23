import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-donner-assigning',
  templateUrl: './donner-assigning.component.html',
  styleUrls: ['./donner-assigning.component.scss']
})
export class DonnerAssigningComponent implements OnInit {

  constructor() { }

  searchKey: string;
  searchByColumn = 'name';
  total = 0;
  startRequests = 0;
  perPage = 10;
  pageNumber = 0;

  ngOnInit() {
  }

}
