import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Transaction } from 'src/app/models/Transaction';
import { ITransactionService } from './ITransactionService';

@Injectable({
  providedIn: 'root'
})
export class TransactionMockService extends ITransactionService {
  
  
  private data: BehaviorSubject<Transaction[]> = new BehaviorSubject([
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
    {  
      hash: '0x8874D1b1f80BD58EfecB29bA09946b6fE39b2961',
      age: '21 Secs ago',
      from: '0xABB1e8CfAdBdE16277Dae3ee36FFFf73689910f4',
      to: '0x1A1e92763d91Ef7cb5660f528bc15D56f7AD5B44',
      quantity: 10
    },
  ]);

  constructor() { super() }

  getData(): Observable<Transaction[]> {
    return this.data.asObservable();
  }

  saveData(data: Transaction): Observable<void> {
    let currentData = this.data.getValue();
    const element = currentData.find(el => el.hash === data.hash)
    if(element) {
      const idx = currentData.indexOf(element);
      currentData[idx] = data
    } else {
      currentData.push(data);
    }
    this.data.next(currentData);
    return of()
  }
}
