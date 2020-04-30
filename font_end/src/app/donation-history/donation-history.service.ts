import {Injectable} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DonationHistoryService {
  constructor(private http: HttpClient, private authService: AuthService) {
  }

  public getHistory() {
  }


}// class
