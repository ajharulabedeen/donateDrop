import {Component, OnInit} from '@angular/core';
import {BasicService} from '../../profile/basic/basic.service';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.scss']
})
export class MyPostsComponent implements OnInit {

  bloods = new Array();
  blood_Group: string;
  quantity: string;
  bloodNeedDate: string;
  patientGender: string;
  relationWithPatient: string;


  constructor(private basicService: BasicService) {
  }

  ngOnInit() {
    window.dispatchEvent(new Event('resize'));
    document.body.className = 'hold-transition skin-blue sidebar-mini';

    this.bloods = this.basicService.getBloodGroup();
    console.log(this.bloods);
  }

}
