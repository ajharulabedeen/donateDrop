import {Injectable} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {HttpClient} from '@angular/common/http';
import {SearchRequest} from './search-request.model';

@Injectable({
  providedIn: 'root'
})
export class DonationHistoryService {
  constructor(private http: HttpClient, private authService: AuthService) {
  }

  public getHistoryCount(searchRequest: SearchRequest) {
    return this.http.post(
      'http://127.0.0.1:8080/public/user/history/searchCount', searchRequest,
      this.authService.getHeader());
  }

  public getHistory() {

  }


}// class
