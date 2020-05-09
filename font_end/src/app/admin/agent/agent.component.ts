import {Component, OnInit} from '@angular/core';
import {AgentServiceService} from './agent-service.service';
import {RequestGetAgentRequests} from './request-get-agent-requests.model';
import {AgentRequestToReview} from './agent-request-to-review.model';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.scss']
})
export class AgentComponent implements OnInit {

  searchKey: string;
  searchByColumn = 'username';
  total = 0;
  startRequests = 0;
  perPage = 10;
  pageNumber = 0;

  agentRequestsToReview: AgentRequestToReview[] = new Array();

  constructor(private agentService: AgentServiceService) {
  }

  ngOnInit() {
  }

  public getAgentRequestsToReview() {
    const agentSearch: RequestGetAgentRequests = new RequestGetAgentRequests(
      this.startRequests.toString(), this.perPage.toString(), this.searchByColumn, this.searchKey);
    console.log(agentSearch);
    this.agentService.getAgentRequestsToReview(agentSearch).subscribe(res => {
      console.log(res);
      for (const key in res) {
        var artr = new AgentRequestToReview();

        artr.addressPermanent = res[key]['addressPermanent'];
        artr.addressPresent = res[key]['addressPresent'];

        artr.gender = res[key]['gender'];
        artr.name = res[key]['name'];
        artr.note = res[key]['note'];

        artr.permanentDist = res[key]['permanentDist'];
        artr.permanentDiv = res[key]['permanentDiv'];
        artr.permanentId = res[key]['permanentId'];
        artr.permanentStreet = res[key]['permanentStreet'];
        artr.permanentUnion = res[key]['permanentUnion'];
        artr.permanentUpz = res[key]['permanentUpz'];

        artr.phone_number = res[key]['phone_number'];

        artr.presentDist = res[key]['presentDist'];
        artr.presentDiv = res[key]['presentDiv'];
        artr.presentId = res[key]['presentId'];
        artr.presentStreet = res[key]['presentStreet'];
        artr.presentUnion = res[key]['presentUnion'];
        artr.presentUpz = res[key]['presentUpz'];

        artr.profession = res[key]['profession'];
        artr.profileId = res[key]['profileId'];
        artr.requestDate = res[key]['requestDate'];
        artr.requestId = res[key]['requestId'];
        artr.status = res[key]['status'];
        artr.userId = res[key]['userId'];
        artr.username = res[key]['username'];

        this.agentRequestsToReview.push(artr);
      }
    });
    console.log(this.agentRequestsToReview);
  }

  // start : for tab in font end.
  public tabChange(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
    }
    tablinks = document.getElementsByClassName('tablinks');
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(' active', '');
    }
    document.getElementById(tabName).style.display = 'block';
    evt.currentTarget.className += ' active';
  }

  // end : for tab in font end.


}
