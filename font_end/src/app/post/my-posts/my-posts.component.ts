import {Component, OnInit} from '@angular/core';
import {BasicService} from '../../profile/basic/basic.service';
import {PostServiceService} from '../post-service.service';
import {Post} from '../post.model';
import {PostSearch} from '../post-search.model';
import {DonnerToAgentRequestToReview} from '../../agent-dashboard/agent-dashboard/model/donner-to-agent-request-to-review.model';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.scss']
})
export class MyPostsComponent implements OnInit {

  dateType: string;
  startDate: string;
  endDate: string;

  searchBy: string;
  sortBy: string;
  orderType: string;
  searchKey: string;
  total: string;

  pageNumber: number;
  startPost: number;
  perPage: number;

  bloodPosts = new Array();

  bloods = new Array();
  blood_Group: string;
  quantity: string;
  bloodNeedDate: string;
  patientGender: string;
  relationWithPatient: string;
  hospitalName: string;
  hospitalAddress: string;
  donationLocation: string;
  contactInfo: string;
  patientDescription: string;
  patientRemarks: string;
  anyNotes: string;
  searchWithinDate: boolean;

  delete_post_id: string;

  edit_post_id: string;
  edit_quantity: string;
  edit_bloodNeedDate: string;
  edit_patientGender: string;
  edit_relationWithPatient: string;
  edit_hospitalName: string;
  edit_hospitalAddress: string;
  edit_donationLocation: string;
  edit_contactInfo: string;
  edit_patientDescription: string;
  edit_patientRemarks: string;
  edit_anyNotes: string;

  postTosave: Post;

  constructor(private basicService: BasicService, private postService: PostServiceService) {
  }

  ngOnInit() {
    window.dispatchEvent(new Event('resize'));
    document.body.className = 'hold-transition skin-blue sidebar-mini';

    this.perPage = 10;
    this.startPost = 0;
    this.dateType = 'need_date';
    this.searchKey = '';
    this.searchBy = 'need_date';
    this.sortBy = 'need_date';
    this.orderType = 'DESC';

    this.getAllPostsByAnUser();
    this.bloods = this.basicService.getBloodGroup();
    this.searchWithinDate = false;
  }

  public save():void {
    this.postService.save(this.getPost()).subscribe((res: Response) => {
      console.log(res);
      if (res['STATUS'] === 'OK') {
        this.bloodPosts.push(this.postTosave);
      }
    });
  }

  public getAllPostsByAnUser() : void{
    var postSearch = new PostSearch();
    postSearch.dateType = this.dateType;
    postSearch.startDate = this.startDate;
    postSearch.endDate = this.endDate;
    postSearch.start = this.startPost.toString();
    postSearch.max = this.perPage.toString();
    postSearch.key = '\'%' + this.searchKey + '%\'';
    postSearch.column = this.searchBy;
    postSearch.orderBy = this.sortBy;
    postSearch.orderType = this.orderType;

    //delete
    console.log(postSearch);

    if (this.searchWithinDate === true) {
      this.postService.countAllPostsByAnUserWithinDate(postSearch).subscribe((res: Response) => {
        console.log(res);
        this.total = res;
      });
      this.postService.getAllPostsByAnUserWithinDate(postSearch).subscribe((res: Response) => {
        console.log(res);
        this.bloodPosts = [];
        this.setMyPostsFromResponse(res);
      });
    } else {
      this.postService.countAllPostsByAnUser(postSearch).subscribe((res: Response) => {
        console.log(res);
        this.total = res;
      });
      this.postService.getAllPostsByAnUser(postSearch).subscribe((res: Response) => {
        console.log(res);
        this.setMyPostsFromResponse(res);
      });
    }
  }

  public setMyPostsFromResponse(res: Response) : void{
    this.bloodPosts = [];
    for (const key in res) {
      var post = new Post();
      post.postID = res[key]['postID'];
      post.bloodType = res[key]['bloodType'];
      post.quantity = res[key]['quantity'];
      post.needDate = res[key]['needDate'];
      post.patientGender = res[key]['patientGender'];
      post.relation = res[key]['relation'];
      post.hospitalName = res[key]['hospitalName'];
      post.hospitalAddress = res[key]['hospitalAddress'];
      post.location = res[key]['location'];
      post.contactInfo = res[key]['contactInfo'];
      post.patientDescription = res[key]['patientDescription'];
      post.remarks = res[key]['remarks'];
      post.notes = res[key]['notes'];
      this.bloodPosts.push(post);
    }
    console.log(this.bloodPosts);
  }

  public getPost() : Post {
    var p = new Post();
    p.bloodType = this.blood_Group;
    p.quantity = this.quantity;
    p.needDate = this.bloodNeedDate;
    p.patientGender = this.patientGender;
    p.relation = this.relationWithPatient;
    p.hospitalName = this.hospitalName;
    p.hospitalAddress = this.hospitalAddress;
    p.location = this.donationLocation;
    p.contactInfo = this.contactInfo;
    p.patientDescription = this.patientDescription;
    p.remarks = this.patientRemarks;
    p.notes = this.anyNotes;
    this.postTosave = p;
    return p;
  }

  public nextPage() : void {
    if (this.startPost.toString() <= this.total) {
      this.startPost += this.perPage;
      this.getAllPostsByAnUser();
    }
  }

  public previousPage() : void {
    if (this.startPost > 0) {
      this.startPost -= this.perPage;
      this.getAllPostsByAnUser();
    }
  }

  public setPostsForEdit(p: Post) : void {
    this.edit_post_id = p.postID;
    this.edit_blood_Group = p.bloodType;
    this.edit_quantity = p.quantity;
    this.edit_bloodNeedDate = p.needDate;
    this.edit_patientGender = p.patientGender;
    this.edit_relationWithPatient = p.relation;
    this.edit_hospitalName = p.hospitalName;
    this.edit_hospitalAddress = p.hospitalAddress;
    this.edit_donationLocation = p.location;
    this.edit_contactInfo = p.contactInfo;
    this.edit_patientDescription = p.patientDescription;
    this.edit_patientRemarks = p.remarks;
    this.edit_anyNotes = p.notes;
  }

  public saveEditPost() {

  }
}
