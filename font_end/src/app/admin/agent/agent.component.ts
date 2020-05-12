import {Component, OnInit} from '@angular/core';
import {AgentServiceService} from './agent-service.service';
import {RequestGetAgentRequests} from './models/request-get-agent-requests.model';
import {AgentRequestToReview} from './models/agent-request-to-review.model';
import {RequestReviewRequest} from './models/request-review-request.model';
import {ReviewValue} from './models/review-value.model';
import {RequestAdminNote} from './models/request-admin-note.model';
import {RequestPersonalNote} from './models/request-personal-note.model';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.scss']
})
export class AgentComponent implements OnInit {

  ngOnInit() {
    this.tabChange(event, 'request_review');
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
    // evt.currentTarget.style.backgroundColor = 'pink';
  }

  // end : for tab in font end.


}// class
