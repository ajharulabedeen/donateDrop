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

    // start : init
    this.blood_Group = 'A+';
    this.gender = 'other';
    // this.present_division = 'Dhaka';
    this.present_district = 'Dhaka';
    // end : init
    this.bloods = this.basicService.getBloodGroup();
    this.getDivisions();


    this.basicExist = false;
    console.log('this.basicExist  : ' + this.basicExist);
    this.basicService.getCurrentUserBasic().subscribe(b => {
      // this.loading = false;
      console.log('res : ' + b);

      // basic information
      this.name = b['name'];
      this.birthDate = b['birthDate'];
      this.gender = b['gender'];
      this.blood_Group = b['blood_Group'];
      this.religion = b['religion'];
      this.profession = b['profession'];
      this.care_of = b['care_of'];
      this.email = b['email'];
      this.available = b['available'];
      this.maritalStatus = b['maritalStatus'];

      // phone number
      for (const key in b['phone_number']) {
        const phoneNumber = new PhoneNumber();
        phoneNumber.$id = b['phone_number'][key]['id'];
        phoneNumber.$number = b['phone_number'][key]['number'];
        this.phoneNumbers.push(phoneNumber);
      }

      // address : present
      console.log('res : ' + b['address_present']['id']);
      this.present_division = b['address_present']['division'];
      console.log('present_division : ' + this.present_division);

      this.present_district = b['address_present']['district'];
      console.log('present_district : ' + this.present_district);

      this.present_upzilla = b['address_present']['upzilla'];
      console.log('present_upzilla : ' + this.present_upzilla);

      this.present_union = b['address_present']['union_ward'];
      console.log('present_union : ' + this.present_union);

      this.present_street_address = b['address_present']['street_address'];
      // address : permanent

    });
    // refactor : not in use now.
    this.setPhoneNumbers();
    // refactor : setBasicInformation not working
    this.setBasicInformation();

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

  // refactor : setBasicInformation not working
  public setBasicInformation() {
    console.log('\n\n--setBasicInformation');
    try {
      var basic: Basic = this.basicService.getBasicInformation();
      this.name = basic.$name;
      this.name = this.basicService.getName();
      console.log(this.name);
      console.log('\n\n name : ' + basic['name']);
      console.log('\n\n $name : ' + basic.$name);
      this.birthDate = basic.$birthDate;
      this.gender = basic.$gender;
      console.log(basic);
    } catch (e) {
      console.log('Error in Setting Basic Information!');
    }
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
      var division: Divisions = this.divisions.find(({name}) => name === this.present_division);
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
      var dist: Districts = this.present_districts.find(({name}) => name === this.present_district);
      console.log('distID : ' + dist);
      var distID = dist.id; // distID = distID['id'];
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
    var upz: Upzillas = this.present_upzillas.find(({name}) => name === this.present_upzilla);
    var upzID = upz.id;
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
      var div: Divisions = this.divisions.find(({name}) => name === this.permanent_division);
      var divID = div.id;
      this.permanent_districts = this.basicService.getDistricts(divID);
      // refactor : bug > clicking in drop down making other empty. fix > after selection list will empty.
      this.permanent_upzillas = [];
      this.permanent_unions = [];
    }
  }

  // after districts selection
  public getPermanent_upzillas(present_districtselected: string) {
    var dist: Districts = this.permanent_districts.find(({name}) => name === this.permanent_district);
    var distID = dist.id;
    this.permanent_upzillas = [];
    // refactor :
    this.permanent_upzillas = this.basicService.getUpzillas(distID);
    this.permanent_unions = [];
  }

  // after upzillas selection
  public getPermanent_unions(upzilaSelected: string) {
    var upz: Upzillas = this.permanent_upzillas.find(({name}) => name === this.permanent_upzilla);
    var upzID = upz.id;
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
