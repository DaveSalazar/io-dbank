export interface ITransaction {
  hash: string;
  age: string;
  from: string;
  to: string;
  quantity: number;
}

export class Transaction implements ITransaction {
  readonly hash: string;
  readonly age: string;
  readonly from: string;
  readonly to: string;
  readonly quantity: number;

  constructor(
    hash: string,
    age: string,
    from: string,
    to: string,
    quantity: number
  ) {
    this.hash = hash;
    this.age = age;
    this.from = from;
    this.to = to;
    this.quantity = quantity;
  }
}