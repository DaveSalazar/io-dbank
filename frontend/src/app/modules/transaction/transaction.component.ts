import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { switchMap } from 'rxjs/operators';
import { ITransaction, Transaction } from 'src/app/models/Transaction';
import { ITransactionService } from 'src/app/services/transaction/ITransactionService';
import { CreateTransactionModal } from './components/create-clinic-modal/create-transaction-modal';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {

  displayedColumns: string[] = [
    'hash',
    'from',
    'to',
    'age',
    'quantity',
  ];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  public dataSource;
  constructor(
    private transactionService: ITransactionService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.loadData();
  }

  openDialog(setting: ITransaction): void {
    const dialogRef = this.dialog.open(CreateTransactionModal, {
      width: '50%', data: setting
    });
    dialogRef.afterClosed()
    .pipe(switchMap(transaction => this.transactionService.saveData(transaction)))
    .subscribe(() => this.loadData());
  }


  loadData() {
    this.transactionService.getData().subscribe((res) => this.setData(res));
  }
  
  setData(data: Transaction[]) {
    this.dataSource = new MatTableDataSource<Transaction>(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}
