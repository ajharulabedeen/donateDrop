import {Component, OnInit} from '@angular/core';
import {BasicService} from './basic.service';
import {Basic} from './basic.model';
import {Observable} from 'rxjs';
import {subscribeOn} from 'rxjs/operators';
import {ThrowStmt, verifyHostBindings} from '@angular/compiler';

@Component({
  selector: 'app-basic',
  templateUrl: './basic.component.html',
  styleUrls: ['./basic.component.scss']
})
export class BasicComponent implements OnInit {

  // dept: string[];
  bloods = new Array();
  divisions = new Array();
  districts = new Array();
  profileEdit = true;

  id: string;
  user_id: string;
  dept: string;
  batch: string;
  student_id: string;
  passing_year: string;
  first_name: string;
  last_name: string;
  birth_date: string;
  gender: string;
  blood_group: string;
  email: string;
  phone: string;
  address_present: string;
  address_permanent: string;
  research_interest: string;
  skills: string;
  image_address: string;
  religion: string;
  social_media_link: string;

  basicExist: boolean;

  constructor(private basicService: BasicService) {
  }


  loadedPosts: Basic[] = [];
  isFetching = false;
  error = null;
  p_division: string;
  p_district: string;
  street_address: string;

  ngOnInit() {

    // start : init
    this.blood_group = 'A+';
    this.gender = 'other';
    this.p_division = 'Dhaka';
    this.p_district = 'Dhaka';
    // end : init
    this.bloods = this.basicService.getBloodGroup();
    this.divisions = this.basicService.getDivisions();

    this.basicExist = false;
    console.log('this.basicExist  : ' + this.basicExist);
    this.basicService.getCurrentUserBasic();
    this.basicService.basic.subscribe(b => {
      for (const key in b) {
        // console.log(key);
        switch (key) {
          case 'user_id': {
            this.user_id = b[key];
            break;
          }
          case 'dept': {
            this.dept = b[key];
            break;
          }
          case 'batch': {
            this.batch = b[key];
            break;
          }
          case 'student_id': {
            this.student_id = b[key];
            break;
          }
          case 'passing_year': {
            this.passing_year = b[key];
            break;
          }
          case 'first_name': {
            this.first_name = b[key];
            break;
          }
          case 'last_name': {
            this.last_name = b[key];
            break;
          }
          case 'birth_date': {
            this.birth_date = b[key];
            // console.log("this.birth_date  : " + this.birth_date);
            break;
          }
          case 'gender': {
            this.gender = b[key];
            break;
          }
          case 'blood_group': {
            this.blood_group = b[key];
            break;
          }
          case 'email': {
            this.email = b[key];
            break;
          }
          case 'phone': {
            this.phone = b[key];
            console.log('Phone : ' + this.phone);
            break;
          }
          case 'address_present': {
            this.address_present = b[key];
            break;
          }
          case 'address_permanent': {
            this.address_permanent = b[key];
            break;
          }
          case 'research_interest': {
            this.research_interest = b[key];
            break;
          }
          case 'skills': {
            this.skills = b[key];
            break;
          }
          case 'image_address': {
            this.image_address = b[key];
            break;
          }
          case 'religion': {
            this.religion = b[key];
            break;
          }
          case 'social_media_link': {
            this.social_media_link = b[key];
            break;
          }
          default: {
            // console.log("Invalid choice");
            break;
          }
        }
      }//for
    });
    console.log('this.basicExist  : ' + this.basicExist);

  }//ngOnInint.


  public editProfile() {
    this.profileEdit = !this.profileEdit;
  }

  public save() {
    this.editProfile();
    this.basicService.create(this.getBasic());
  }

  public update() {
    this.editProfile();
    this.basicService.update(this.getBasic());
  }


  public getBasic() {
    var basic = new Basic();
    basic.$dept = this.dept;
    basic.$batch = this.batch;
    basic.$student_id = this.student_id;
    basic.$passing_year = this.passing_year;
    basic.$first_name = this.first_name;
    basic.$last_name = this.last_name;
    basic.$birth_date = this.birth_date;
    basic.$gender = this.gender;
    basic.$blood_group = this.blood_group;
    basic.$email = this.email;
    basic.$phone = this.phone;
    basic.$address_permanent = this.address_present;
    basic.$address_permanent = this.address_permanent;
    basic.$research_interest = this.research_interest;
    basic.$skills = this.skills;
    basic.$image_address = this.image_address;
    basic.$religion = this.religion;
    basic.$social_media_link = this.social_media_link;

    console.log(basic);//remove
    return basic;
  }

  public getdistricts(divisionSelected: string) {
    console.log('selected Division  : ' + this.p_division);
    this.districts = this.basicService.getdistricts(divisionSelected);
  }

  divisionPrint() {
    console.log('p_division : ' + this.p_division);
  }
}//class
