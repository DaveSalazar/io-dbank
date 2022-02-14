export interface IProfile {
  id: string;
  firstName: string;
  lastName: string;
}

export class Profile implements IProfile {
  readonly id: string;
  readonly firstName: string;
  readonly lastName: string;

  constructor(
    id: string,
    firstName: string,
    lastName: string
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
