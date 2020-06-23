import {Component, OnInit} from '@angular/core';
import {DonnerToAgentRequestToReview} from '../model/donner-to-agent-request-to-review.model';
import {AgentDashboardServiceService} from '../agent-dashboard-service.service';
import {RequestSearchReview} from '../model/request-search-review.model';
import {RequestReviewRequest} from '../../../admin/agent/models/request-review-request.model';
import {RequestNote} from '../model/request-note.model';
// import {ReviewValue} from '../../../admin/agent/models/review-value.model';

@Component({
  selector: 'app-agent-dashboard-accepted',
  templateUrl: './agent-dashboard-accepted.component.html',
  styleUrls: ['./agent-dashboard-accepted.component.scss']
})
export class AgentDashboardAcceptedComponent implements OnInit {

  searchKey: string;
  searchByColumn = 'username';
  total = 0;
  startRequests = 0;
  perPage = 10;
  pageNumber = 0;
  phoneNumber = '';

  requestID: string;
  agentNote: string;
  personalNote: string;

  donnerRequestsToReview: DonnerToAgentRequestToReview[] = new Array();
  // rivewValue: ReviewValue = new ReviewValue();

  constructor(private adService: AgentDashboardServiceService) {
  }

  ngOnInit() {
    this.searchKey = '';
    this.getDonnerRequestsToReview();
  }

  public getDonnerRequestsToReview() {
    var finalSearchKey = '%' + this.searchKey + '%';
    const search: RequestSearchReview = new RequestSearchReview(
      this.startRequests.toString(), this.perPage.toString(), this.searchByColumn, finalSearchKey, this.rivewValue.ACCEPT);
    console.log(search);
    this.donnerRequestsToReview = [];
    this.adService.getDonnerToAgentRequestToReview(search).subscribe(res => {
      console.log('res : ' + res);
      for (const key in res) {
        var artr = new DonnerToAgentRequestToReview();

        artr.addressPermanent = res[key]['addressPermanent'];
        artr.addressPresent = res[key]['addressPresent'];

        artr.gender = res[key]['gender'];
        artr.name = res[key]['name'];
        artr.noteDonner = res[key]['noteDonner'];
        artr.noteAgent = res[key]['noteAgent'];
        artr.noteAgentPersonal = res[key]['noteAgentPersonal'];
        console.log(res[key]['notePersonal']);

        artr.permanentDist = res[key]['permanentDist'];
        artr.permanentDiv = res[key]['permanentDiv'];
        artr.permanentId = res[key]['permanentId'];
        artr.permanentStreet = res[key]['permanentStreet'];
        artr.permanentUnion = res[key]['permanentUnion'];
        artr.permanentUpz = res[key]['permanentUpz'];

        // artr.phone_number = res[key]['phone_number'];
        artr.phone_number = '';
        for (const phoneKey in res[key]['phone_number']) {
          artr.phone_number += res[key]['phone_number'][phoneKey]['number'] + ';\n';
          // console.log(res[key]['phone_number'][phoneKey]['number']);
        }
        // console.log(artr.phone_number);
        // console.log(res[key]['phone_number']);

        artr.presentDist = res[key]['presentDist'];
        artr.presentDiv = res[key]['presentDiv'];
        artr.presentId = res[key]['presentId'];
        artr.presentStreet = res[key]['presentStreet'];
        artr.presentUnion = res[key]['presentUnion'];
        artr.presentUpz = res[key]['presentUpz'];

        artr.profession = res[key]['profession'];
        artr.profileId = res[key]['profileId'];
        artr.acceptDate = res[key]['acceptDate'];
        artr.requestId = res[key]['requestId'];
        artr.status = res[key]['status'];
        artr.userId = res[key]['userId'];
        artr.username = res[key]['username'];

        this.donnerRequestsToReview.push(artr);
      }
    });
    console.log(this.donnerRequestsToReview);
    this.adService.getDonnerToAgentRequestReviewCount(search).subscribe(res => {
      console.log(res);
      this.total = res['COUNT'];
    });
  }

  // yet to apply

  public nextPage() {
    if (this.startRequests <= this.total) {
      this.startRequests += this.perPage;
      this.getDonnerRequestsToReview();
    }
  }

  public previousPage() {
    if (this.startRequests > 0) {
      this.startRequests -= this.perPage;
      this.getDonnerRequestsToReview();
    }
  }

  public requestRemove(requestIdReject: string) {
    // const reviewRequestReject: RequestReviewRequest = new RequestReviewRequest(requestIdReject, this.rivewValue.REMOVE);//dont know get working but what problem with, this.s
    const reviewRequestReject: RequestReviewRequest = new RequestReviewRequest(requestIdReject, 'REMOVE');
    console.log(reviewRequestReject);
    this.adService.donnerRequestReview(reviewRequestReject).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        // this.getDonnerRequestsToReview();
        var artr: DonnerToAgentRequestToReview = this.donnerRequestsToReview.find(({requestId}) => requestId === requestIdReject);
        this.donnerRequestsToReview = this.donnerRequestsToReview.filter(obj => obj !== artr);
        this.total -= 1;
      }
    });
  }

  public requestAccept(requestIdAccept: string, value: string) {
    const reviewRequestAccept: RequestReviewRequest = new RequestReviewRequest(requestIdAccept, value);
    // console.log(requestId);
    console.log(reviewRequestAccept);
    this.adService.donnerRequestReview(reviewRequestAccept).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        // this.getDonnerRequestsToReview();
        // var hist: History = this.historyDonation.find(({id}) => id === this.deleteId);
        var artr: DonnerToAgentRequestToReview = this.donnerRequestsToReview.find(({requestId}) => requestId === requestIdAccept);
        this.donnerRequestsToReview = this.donnerRequestsToReview.filter(obj => obj !== artr);
        this.total -= 1;
      }
    });
  }

  public updateAgentNote() {
    const note = new RequestNote(this.requestID, this.agentNote);
    console.log('this.agentNote : ' + this.agentNote);
    console.log(note);
    this.adService.updateAgentNote(note).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        this.getDonnerRequestsToReview();
      }
    });
  }

  public updateAgentPersonalNote() {
    const note = new RequestNote(this.requestID, this.personalNote);
    console.log(note);
    this.adService.updateAgentPersonalNote(note).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        this.getDonnerRequestsToReview();
      }
    });
  }


}
