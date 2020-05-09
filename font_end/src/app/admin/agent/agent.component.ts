import {Component, OnInit} from '@angular/core';
import {AgentServiceService} from './agent-service.service';
import {RequestGetAgentRequests} from './request-get-agent-requests.model';

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
    });
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
