import {Component, OnInit} from '@angular/core';

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

  constructor() {
  }

  ngOnInit() {
  }

}
