import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ITransaction } from 'src/app/models/Transaction';

@Component({
  selector: 'create-transaction',
  templateUrl: './create-transaction-modal.html',
  styles: [`
  mat-form-field {
    width: 100%;
  }
  textarea {
    height: 100%
  }
  `],
})
export class CreateTransactionModal implements OnInit {

  public transaction: ITransaction = {
    hash: '',
    age: '',
    from: '',
    to: '',
    quantity: 0
  };

  constructor(
    public dialogRef: MatDialogRef<CreateTransactionModal>,
    @Inject(MAT_DIALOG_DATA) public data: ITransaction
  ) {
    if (data) {
      this.transaction = data;
    }
  }
  
  ngOnInit(): void {
   
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
