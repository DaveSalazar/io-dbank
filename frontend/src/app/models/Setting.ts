export interface ISetting {
  id: string;
  userId: string;
  name: string;
  value: string;
}

export class Setting implements ISetting {
  readonly id: string;
  readonly userId: string;
  readonly name: string;
  readonly value: string;

  constructor(
    id: string,
    userId: string,
    name: string,
    value: string
  ) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.value = value;
  }
}