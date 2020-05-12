import {Component, OnInit} from '@angular/core';
import {ReviewValue} from '../models/review-value.model';
import {RequestPersonalNote} from '../models/request-personal-note.model';
import {RequestReviewRequest} from '../models/request-review-request.model';
import {RequestAdminNote} from '../models/request-admin-note.model';
import {AgentRequestToReview} from '../models/agent-request-to-review.model';
import {AgentServiceService} from '../agent-service.service';
import {RequestGetAgentRequests} from '../models/request-get-agent-requests.model';

@Component({
  selector: 'app-agent-freeze',
  templateUrl: './agent-freeze.component.html',
  styleUrls: ['./agent-freeze.component.scss']
})
export class AgentFreezeComponent implements OnInit {

  searchKey: string;
  searchByColumn = 'username';
  total = 0;
  startRequests = 0;
  perPage = 10;
  pageNumber = 0;
  phoneNumber = '';

  requestID: string;
  adminNote: string;
  personalNote: string;

  agentRequestsToReview: AgentRequestToReview[] = new Array();
  rivewValue: ReviewValue = new ReviewValue();

  constructor(private agentService: AgentServiceService) {
  }

  ngOnInit() {
    this.searchKey = '';
    this.getAgentRequestsToReview();
  }

  public getAgentRequestsToReview() {
    var finalSearchKey = '%' + this.searchKey + '%';
    const agentSearch: RequestGetAgentRequests = new RequestGetAgentRequests(
      this.startRequests.toString(), this.perPage.toString(), this.searchByColumn, finalSearchKey, 'REJECT');
    console.log(agentSearch);
    this.agentRequestsToReview = [];
    this.agentService.getAgentRequestsToReview(agentSearch).subscribe(res => {
      console.log('res : ' + res);
      for (const key in res) {
        var artr = new AgentRequestToReview();

        artr.addressPermanent = res[key]['addressPermanent'];
        artr.addressPresent = res[key]['addressPresent'];

        artr.gender = res[key]['gender'];
        artr.name = res[key]['name'];
        artr.noteApplicant = res[key]['noteApplicant'];
        artr.noteAdmin = res[key]['noteAdmin'];
        artr.notePersonal = res[key]['notePersonal'];
        // console.log(res[key]['notePersonal']);

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
          console.log(res[key]['phone_number'][phoneKey]['number']);
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
        artr.requestDate = res[key]['rejectDate'];
        // console.log(res[key]['rejectDate']);

        artr.requestId = res[key]['requestId'];
        artr.status = res[key]['status'];
        artr.userId = res[key]['userId'];
        artr.username = res[key]['username'];

        this.agentRequestsToReview.push(artr);
      }
    });
    // console.log(this.agentRequestsToReview);
    this.agentService.getAgentRequestsToReviewCount(agentSearch).subscribe(res => {
      console.log(res);
      this.total = res['COUNT'];
    });
  }

  public nextPage() {
    if (this.startRequests <= this.total) {
      this.startRequests += this.perPage;
      this.getAgentRequestsToReview();
    }
  }

  public previousPage() {
    if (this.startRequests > 0) {
      this.startRequests -= this.perPage;
      this.getAgentRequestsToReview();
    }
  }

  public requestAccept(requestIdFreeze: string, value: string) {
    const reviewRequestAccept: RequestReviewRequest = new RequestReviewRequest(requestIdFreeze, value);
    // console.log(requestId);
    console.log(reviewRequestAccept);
    this.agentService.requestReview(reviewRequestAccept).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        // this.getAgentRequestsToReview();
        var artr: AgentRequestToReview = this.agentRequestsToReview.find(({requestId}) => requestId === requestIdFreeze);
        this.agentRequestsToReview = this.agentRequestsToReview.filter(obj => obj !== artr);
        this.total -= 1;
      }
    });
  }

  public updateAdminNote() {
    const adminNote = new RequestAdminNote(this.requestID, this.adminNote);
    console.log(adminNote);
    this.agentService.updateAdminNote(adminNote).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        this.getAgentRequestsToReview();
      }
    });
  }

  public updatePersonalNote() {
    const personalNoteObj = new RequestPersonalNote(this.requestID, this.personalNote);
    console.log(personalNoteObj);
    this.agentService.updatePersonalNote(personalNoteObj).subscribe(res => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        this.getAgentRequestsToReview();
      }
    });
  }

}
