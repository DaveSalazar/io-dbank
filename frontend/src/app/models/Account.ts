export interface IAccount {
  address: string;
}

export class Account implements IAccount {
  readonly address: string;

  constructor(address: string) {
    this.address = address
  }
}