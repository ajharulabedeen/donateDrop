import {Component, OnInit} from '@angular/core';
import {DonationHistoryService} from './donation-history.service';
import {SearchRequest} from './search-request.model';

@Component({
  selector: 'app-donation-history',
  templateUrl: './donation-history.component.html',
  styleUrls: ['./donation-history.component.scss']
})
export class DonationHistoryComponent implements OnInit {
  searchBy: string;
  perPage: string;
  total: string;
  pageNumber: string;
  sortBy: string;
  searchKey: string;

  constructor(private serviceHistory: DonationHistoryService) {
  }

  ngOnInit() {
    this.searchBy = 'location';
    this.searchKey = '';
    window.dispatchEvent(new Event('resize'));
    document.body.className = 'hold-transition skin-blue sidebar-mini';
  }

  public searchCount() {
    var srcRequest = new SearchRequest();
    srcRequest.column = this.searchBy;
    srcRequest.key = this.searchKey;
    srcRequest.start = '0';
    srcRequest.perPage = this.perPage;
    srcRequest.userID = '';
    console.log(srcRequest);
    this.serviceHistory.getHistoryCount(srcRequest).subscribe(res => {
      console.log(res);
    });
    // userID, column, key, start
  }


}
