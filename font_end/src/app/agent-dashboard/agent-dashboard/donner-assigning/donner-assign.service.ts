import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../../auth/auth.service';
import {RequestSearchReview} from '../model/request-search-review.model';

@Injectable({
  providedIn: 'root'
})
export class DonnerAssignService {

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  // public getDonnerToAgentRequestToReview(search: RequestSearchReview) {
  //   return this.http.post(
  //     'http://localhost:8080/public/user/agent/donner/getDonnerToAgentRequestToReview', search,
  //     this.authService.getHeader());
  // }

}
