import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Transaction } from 'src/app/models/Transaction';
import { ITransactionService } from 'src/app/services/transaction/ITransactionService';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.scss']
})
export class TransactionComponent implements OnInit {

  displayedColumns: string[] = [
    'hash',
    'age',
    'from',
    'to',
    'quantity',
  ];
  
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  public dataSource;
  constructor(private transactionService: ITransactionService) { }

  ngOnInit(): void {
    this.loadData();
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
