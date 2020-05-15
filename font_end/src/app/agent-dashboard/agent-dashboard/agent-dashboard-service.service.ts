import {Injectable} from '@angular/core';
import {RequestGetAgentRequests} from '../../admin/agent/models/request-get-agent-requests.model';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AgentDashboardServiceService {

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  // http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestReviewCount
  // http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestToReview
  public getDonnerToAgentRequestToReview(agentSearch: RequestGetAgentRequests) {
    return this.http.post(
      'http://localhost:8080/public/user/agent/admin/getAgentRequestsToReview', agentSearch,
      this.authService.getHeader());
  }

  // http://localhost:8080/public/user/agent/donner/reviewDonnerRequest
  // http://localhost:8080/public/user/agent/donner/updateAgentNote
  // http://localhost:8080/public/user/agent/donner/updateNoteAgentPersonal

}
