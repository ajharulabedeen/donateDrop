import {Component, OnInit} from '@angular/core';
import {RequestSearchDonnerAssing} from '../model/request-search-donner-assign.model';
import {DonnerAssingShow} from '../model/donner-assing-show.model';
import {DonnerAssignService} from './donner-assign.service';
import {throttleTime} from 'rxjs/operators';

@Component({
  selector: 'app-donner-assigning',
  templateUrl: './donner-assigning.component.html',
  styleUrls: ['./donner-assigning.component.scss']
})
export class DonnerAssigningComponent implements OnInit {

  searchKey: string;
  searchByColumn = 'name';
  total = 0;
  startAssigments = 0;
  perPage = 10;
  pageNumber = 0;
  statusType: string;
  assignmentStatus: string;

  deleteId: string;

  donnerAssingmentAll: Array<DonnerAssingShow>;
  startAssingments: number;

  constructor(private donnerAssignService: DonnerAssignService) {
  }

  ngOnInit() {
    this.searchKey = '';
    this.statusType = '0';
    this.assignmentStatus = '0';
    this.startAssingments = 0;
    this.getAssingments();
  }

  public getAssingments(): void {
    const donnerAssingSearch = new RequestSearchDonnerAssing();
    donnerAssingSearch.start = this.startAssigments;
    donnerAssingSearch.max = this.perPage;
    donnerAssingSearch.column = this.searchByColumn;
    donnerAssingSearch.key = '%' + this.searchKey + '%';
    donnerAssingSearch.statusType = this.assignmentStatus;
    this.donnerAssingmentAll = new Array<DonnerAssingShow>();

    console.log(donnerAssingSearch);

    this.donnerAssignService.getAssingments(donnerAssingSearch).subscribe(donnerAssignment => {
      this.donnerAssingmentAll = donnerAssignment;
      console.log(this.donnerAssingmentAll);
    });
  }


  deleteAssignment(): void {
    this.donnerAssignService.delete(this.deleteId).subscribe(res => {
      if (res.STATUS === 'OK') {
        this.getAssingments();
      }
    });
  }
}
