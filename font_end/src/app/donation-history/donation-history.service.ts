import {Injectable} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {HttpClient} from '@angular/common/http';
import {SearchRequest} from './search-request.model';
import {History} from './history.model';

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

  public getHistory(srcRequest: SearchRequest): History[] {
    // return this.http.post(
    //   'http://127.0.0.1:8080/public/user/history/search', srcRequest,
    //   this.authService.getHeader());

    var h: History[];

    this.http.post(
      'http://127.0.0.1:8080/public/user/history/search', srcRequest,
      this.authService.getHeader()).subscribe(res => {
      for (const key in res) {
        var his = new History();
        his.$id = res['id'];
        his.$date = res['date'];
        his.$date = res['location'];
        his.$date = res['note'];
        his.$date = res['patientDescription'];
        his.$date = res['refferedBy'];
        his.$date = res['userId'];
        h.push(his);
      }
    });
    return h;
  }


}// class
