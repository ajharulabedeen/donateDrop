import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../auth/auth.service';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.scss']
})
export class PostDetailsComponent implements OnInit {

  public postID: string;
  public needDate: string;
  public bloodType: string;
  public quantity: string;
  public patientGender: string;
  public relation: string;
  public hospitalName: string;
  public hospitalAddress: string;
  public location: string;
  public contactInfo: string;
  public patientDescription: string;

  public postIdDetails: string;

  constructor(private activeRoute: ActivatedRoute,
              private http: HttpClient,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.postIdDetails = this.activeRoute.snapshot.params['post_id'];
    console.log('postID for Details: ' + this.postIdDetails);
    // this.getOneNews(this.id);
  }

}
