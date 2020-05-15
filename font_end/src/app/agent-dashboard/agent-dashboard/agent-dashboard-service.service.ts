import {Injectable} from '@angular/core';
import {RequestGetAgentRequests} from '../../admin/agent/models/request-get-agent-requests.model';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../auth/auth.service';
import {RequestSearchReview} from './model/request-search-review.model';

@Injectable({
  providedIn: 'root'
})
export class AgentDashboardServiceService {

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  // http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestReviewCount
  public getDonnerToAgentRequestReviewCount(search: RequestSearchReview) {
    return this.http.post(
      'http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestReviewCount', search,
      this.authService.getHeader());
  }

  // http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestToReview
  public getDonnerToAgentRequestToReview(search: RequestSearchReview) {
    return this.http.post(
      'http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestToReview', search,
      this.authService.getHeader());
  }

  // http://localhost:8080/public/user/agent/donner/reviewDonnerRequest
  // http://localhost:8080/public/user/agent/donner/updateAgentNote
  // http://localhost:8080/public/user/agent/donner/updateNoteAgentPersonal

}
