import {Component, OnInit} from '@angular/core';
import {Student} from '../student.model';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.scss']
})
export class ParentComponent {

  parentTitle = 'Parent Component';

  // Property for child component one
  cityMsg = 'Indian City Names';
  cityArray = ['Varanasi', 'Delhi', 'Mumbai'];
  stdAddMsg = 'Add Student';

  // Property for child component two
  stdMsg = 'Student Leader Detail';
  stdLeaderObj = new Student('Narendra', 'Modi');

  // Property used in parent
  stdFullName = '';
  sum = '';
  msg = '';

  saveData(std) {
    this.stdFullName = std.fname + ' ' + std.lname;
  }

  printSum(res) {
    this.sum = res;
  }

  printMsg(msg) {
    this.msg = msg;
  }

}
