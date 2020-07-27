import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  // start-new : reusable component
  REJECTED = 'REJECT';
  ACCEPTED = 'ACCEPT';
  REMOVE = 'REMOVE';

  //modal id : note for the donner.
  REJECTED_ID = 'REJECT_MODAL';
  ACCEPTED_ID = 'ACCEPT_MODAL';
  REMOVE_ID = 'REMOVE_MODAL';


  headerAccepted = 'Request Accepted';
  headerRejected = 'Request Rejected';
  headerRemove = 'Request Remove';
  headerReview = 'Request to Review';

// end-new : reusable component


  constructor() {
  }

  ngOnInit() {
    window.dispatchEvent(new Event('resize'));
    document.body.className = 'hold-transition skin-blue sidebar-mini';
    // this.tabChange(event, 'request_review');
    // this.tabChange(event, 'accepted');
    // this.tabChange(event, 'rejected');
    this.tabChange(event, 'removed');
  }


  // start : for tab in font end.
  public tabChange(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName('tabcontent');
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = 'none';
    }
    tablinks = document.getElementsByClassName('tablinks');
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(' active', '');
    }
    document.getElementById(tabName).style.display = 'block';
    // document.getElementById(tabName).style.background = 'pink';
    // evt.currentTarget.className += ' active';
    // console.log(evt.currentTarget.className);
    // evt.currentTarget.style.backgroundColor = 'pink';
  }

  // end : for tab in font end.


}
