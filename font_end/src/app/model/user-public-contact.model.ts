import {PhoneNumber} from '../profile/basic/phone-number.model';

export class UserPublicContact {
  contactType: string;
  name: string;
  email: string;
  phoneNumbers: Array<PhoneNumber>;
}
