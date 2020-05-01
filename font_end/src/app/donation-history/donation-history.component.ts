import {Component, OnInit} from '@angular/core';
import {DonationHistoryService} from './donation-history.service';
import {SearchRequest} from './search-request.model';
import {History} from './history.model';

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
  public historyDonation: History[] = new Array();

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
    srcRequest.key = '%' + this.searchKey + '%';
    srcRequest.start = '0';
    srcRequest.perPage = this.perPage;
    srcRequest.userID = '';
    console.log(srcRequest);
    this.serviceHistory.getHistoryCount(srcRequest).subscribe(res => {
      console.log(res);
      this.total = res['COUNT'];
    });
    // userID, column, key, start
  }

  public getAll() {
    var srcRequest = new SearchRequest();
    srcRequest.column = this.searchBy;
    srcRequest.key = '%' + this.searchKey + '%';
    srcRequest.start = '0';
    srcRequest.perPage = this.perPage;
    srcRequest.userID = '';
    console.log(srcRequest);
    this.serviceHistory.getHistory(srcRequest).subscribe(res => {
      console.log(res);
      for (const key in res) {
        var his = new History();
        his.$id = res['id'];
        his.$date = res['date'];
        his.$location = res['location'];
        his.$note = res['note'];
        his.$patient_description = res['patientDescription'];
        his.$reffered_by = res['refferedBy'];
        his.$user_id = res['userId'];
        this.historyDonation.push(his);
      }
    });

    // this.historyDonation = this.serviceHistory.getHistory(srcRequest);
    // console.log(this.historyDonation);

  }

}
