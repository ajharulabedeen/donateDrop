import {Component, OnInit} from '@angular/core';
import {RequestSearchDonnerAssing} from '../model/request-search-donner-assign.model';

@Component({
  selector: 'app-donner-assigning',
  templateUrl: './donner-assigning.component.html',
  styleUrls: ['./donner-assigning.component.scss']
})
export class DonnerAssigningComponent implements OnInit {

  constructor() {
  }

  searchKey: string;
  searchByColumn = 'name';
  total = 0;
  startAssigments = 0;
  perPage = 10;
  pageNumber = 0;
  statusType: string;
  assignmentStatus: string;

  ngOnInit() {
  }

  public getAssingments(): void {
    const donnerAssingSearch = new RequestSearchDonnerAssing();
    donnerAssingSearch.start = this.startAssigments;
    donnerAssingSearch.max = this.perPage;
    donnerAssingSearch.column = this.searchKey;
    donnerAssingSearch.key = this.searchByColumn;
    donnerAssingSearch.statusType =this.assignmentStatus;
  }

}

