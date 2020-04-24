import {Component, OnInit} from '@angular/core';
import {BasicService} from './basic.service';
import {Basic} from './basic.model';
import {Observable} from 'rxjs';
import {subscribeOn} from 'rxjs/operators';
import {ThrowStmt, verifyHostBindings} from '@angular/compiler';
import {Divisions} from './divisions.model';
import {Districts} from './districts.model';
import {Unions} from './unions.model';
import {Upzillas} from './upzillas.model';
import {PhoneNumber} from './phone-number.model';

@Component({
  selector: 'app-basic',
  templateUrl: './basic.component.html',
  styleUrls: ['./basic.component.scss']
})
export class BasicComponent implements OnInit {

  // dept: string[];
  bloods = new Array();


  profileEdit = true;
  loadedPosts: Basic[] = [];
  isFetching = false;
  error = null;
  basicExist: boolean;

  // basic
  id: string;
  userId: string;
  name: string;
  birthDate: string;
  care_of: string;
  gender: string;
  maritalStatus: string;
  profession: string;
  blood_Group: string;
  available: string;
  religion: string;
  email: string;


  // phone numbers
  phoneNumbers: PhoneNumber[]; // will be inited at first.
  phoneNumber: string;

  divisions: Divisions[] = new Array(); // used for both permanent and present.
  // address : present
  present_districts: Districts[] = new Array();
  present_upzillas: Upzillas[] = new Array();
  present_unions = new Array();
  present_division: string;
  present_district: string;
  present_upzilla: string;
  present_union: string;
  present_street_address: string;

// address : permanent
  permanent_districts: Districts[] = new Array();
  permanent_upzillas: Upzillas[] = new Array();
  permanent_unions = new Array();
  permanent_division: string;
  permanent_district: string;
  permanent_upzilla: string;
  permanent_uinon: string;
  permanent_street_address: string;
  // education
  dept: string;
  batch: string;
  student_id: string;
  passing_year: string;


  constructor(private basicService: BasicService) {
  }


  ngOnInit() {

    this.setPhoneNumbers();
    this.setBasicInformation();
    // start : init
    this.blood_Group = 'A+';
    this.gender = 'other';
    // this.present_division = 'Dhaka';
    // this.present_district = 'Dhaka';
    // end : init
    this.bloods = this.basicService.getBloodGroup();
    this.getDivisions();


    this.basicExist = false;
    console.log('this.basicExist  : ' + this.basicExist);
    this.basicService.getCurrentUserBasic();
    this.basicService.basic.subscribe(b => {
      // for (const key in b) {
      //   // console.log(key);
      //   switch (key) {
      //     case 'user_id': {
      //       this.user_id = b[key];
      //       break;
      //     }
      //     case 'dept': {
      //       this.dept = b[key];
      //       break;
      //     }
      //     case 'batch': {
      //       this.batch = b[key];
      //       break;
      //     }
      //     case 'student_id': {
      //       this.student_id = b[key];
      //       break;
      //     }
      //     case 'passing_year': {
      //       this.passing_year = b[key];
      //       break;
      //     }
      //     case 'first_name': {
      //       this.first_name = b[key];
      //       break;
      //     }
      //     case 'last_name': {
      //       this.last_name = b[key];
      //       break;
      //     }
      //     case 'birth_date': {
      //       this.birth_date = b[key];
      //       // console.log("this.birth_date  : " + this.birth_date);
      //       break;
      //     }
      //     case 'gender': {
      //       this.gender = b[key];
      //       break;
      //     }
      //     case 'blood_group': {
      //       this.blood_group = b[key];
      //       break;
      //     }
      //     case 'email': {
      //       this.email = b[key];
      //       break;
      //     }
      //     case 'phone': {
      //       this.phone = b[key];
      //       console.log('Phone : ' + this.phone);
      //       break;
      //     }
      //     case 'address_present': {
      //       this.address_present = b[key];
      //       break;
      //     }
      //     case 'address_permanent': {
      //       this.address_permanent = b[key];
      //       break;
      //     }
      //     case 'research_interest': {
      //       this.research_interest = b[key];
      //       break;
      //     }
      //     case 'skills': {
      //       this.skills = b[key];
      //       break;
      //     }
      //     case 'image_address': {
      //       this.image_address = b[key];
      //       break;
      //     }
      //     case 'religion': {
      //       this.religion = b[key];
      //       break;
      //     }
      //     case 'social_media_link': {
      //       this.social_media_link = b[key];
      //       break;
      //     }
      //     default: {
      //       // console.log("Invalid choice");
      //       break;
      //     }
      //   }
      // } // for
    });
    console.log('this.basicExist  : ' + this.basicExist);

  }// ngOnInint.

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
    basic.$name = this.name;
    basic.$birthDate = this.birthDate;
    basic.$gender = this.gender;
    basic.$blood_Group = this.blood_Group;
    basic.$religion = this.religion;
    basic.$profession = this.profession;
    basic.$care_of = this.care_of;
    basic.$email = this.email;
    basic.$available = this.available;
    basic.$maritalStatus = this.maritalStatus;
    console.log(basic); // remove
    return basic;
  }

  public setBasicInformation() {
    var basic = new Basic();
    try {
      basic = this.basicService.getBasicInformation();
    } catch (e) {
      console.log('Error in Setting Basic Information!');
    }
    console.log(basic);
  }


  public setPhoneNumbers() {
    console.log('\n this.phoneNumbers : \n' + this.phoneNumbers);
    this.phoneNumbers = this.basicService.getPhoneNumbers();
    console.log('\n this.phoneNumbers : \n' + this.phoneNumbers);
  }

  public addPhoneNumber() {
    console.log(this.phoneNumber);
    var newNumber: PhoneNumber;
    newNumber = this.basicService.addPhoneNumber(this.phoneNumber);
    if (newNumber != null) {
      this.phoneNumbers.push(newNumber);
    }
  }

  public deletePhoneNumber(p: PhoneNumber) {
    console.log(p);
    this.phoneNumbers = this.phoneNumbers.filter(obj => obj !== p);
    const status = this.basicService.deletePhoneNumber(p);
    console.log('\n\n status component: ' + status);
    if (status === 'OK') {
      console.log('Delete Success!');
    }
  }


  // start : present address geo code
  // after division selection
  public getPresent_districts(present_division: string) {
    var divID = '3';
    if (this.present_division != null) {
      this.present_districts = new Array();
      var division : Divisions = this.divisions.find( ({name}) => name === this.present_division );
      divID = division.id;
      console.log('selected Division  : ' + this.present_division);
      this.present_districts = this.basicService.getDistricts(divID);
      this.present_upzillas = [];
      this.present_unions = [];
    }
  }

  // after districts selection
  public getPresent_upzillas(present_district: string) {
    try {
      console.log('selected District  : ' + this.present_district);
      var distID = this.present_districts.find(({name}) => name === this.present_district);
      console.log('distID : ' + distID);
      distID = distID['id'];
      console.log('distID : ' + distID);
      this.present_upzillas = [];
      this.present_upzillas = this.basicService.getUpzillas(distID);
      this.present_unions = [];
    } catch (e) {
      console.log('Error in setting Uninons Name!');
    }

  }

  // after upzillas selection
  public getPresent_unions(upzilaSelected: string) {
    console.log('selected Upzillas: ' + this.present_upzilla);
    var upzID = this.present_upzillas.find(({name}) => name === this.present_upzilla);
    upzID = upzID['id'];
    // console.log('upzID : ' + upzID);
    this.present_unions = [];
    this.present_unions = this.basicService.getUnions(upzID);
  }

// end : present address geo code

  // start : permanent address geo code
  // after division selection
  public getPermanent_districts(present_division: string) {
    var divID = '3';
    if (this.permanent_division != null) {
      this.permanent_districts = [];
      divID = this.divisions.find(({name}) => name === this.permanent_division);
      divID = divID['id'];
      this.permanent_districts = this.basicService.getDistricts(divID);
      // refactor : bug > clicking in drop down making other empty. fix > after selection list will empty.
      this.permanent_upzillas = [];
      this.permanent_unions = [];
    }
  }

  // after districts selection
  public getPermanent_upzillas(present_districtselected: string) {
    var distID = this.permanent_districts.find(({name}) => name === this.permanent_district);
    distID = distID['id'];
    this.permanent_upzillas = [];
    // refactor :
    this.permanent_upzillas = this.basicService.getUpzillas(distID);
    this.permanent_unions = [];
  }

  // after upzillas selection
  public getPermanent_unions(upzilaSelected: string) {
    var upzID = this.permanent_upzillas.find(({name}) => name === this.permanent_upzilla);
    upzID = upzID['id'];
    if (upzID != null) {
      this.permanent_unions = [];
      this.permanent_unions = this.basicService.getUnions(upzID);
    }
  }

// end : permanent address geo code


  public getDivisions() {
    this.divisions = [];
    this.divisions = this.basicService.getDivisions();
    console.log(this.divisions);
  }

  public divisionPrint() {
    var div = this.divisions.find(({name}) => name === this.present_division);
    console.log(div);
    console.log('present_division : ' + this.present_division);
  }

  divIDPrint(id: string) {
    console.log('divID : ' + id);
  }


} // class
