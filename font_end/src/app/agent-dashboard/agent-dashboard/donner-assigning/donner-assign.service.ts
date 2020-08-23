import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../../auth/auth.service';
import {RequestSearchReview} from '../model/request-search-review.model';
import {RequestSearchDonnerAssing} from '../model/request-search-donner-assign.model';
import {DonnerAssingShow} from '../model/donner-assing-show.model';

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

  getAssingments(donnerAssingSearch: RequestSearchDonnerAssing) {
    return this.http.post<DonnerAssingShow[]>('http://localhost:8080/public/user/agent/donnerAssign/getAssingments', donnerAssingSearch, this.authService.getHeader());
  }

  delete(deleteId: string) {
    return this.http.delete('http://localhost:8080/public/user/agent/donnerAssign/delete?donnerAssingmentID=' + deleteId, this.authService.getHeader());
  }


}
