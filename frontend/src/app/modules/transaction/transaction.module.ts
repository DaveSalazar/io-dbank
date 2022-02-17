import { NgModule } from '@angular/core';
import { ITransactionService } from 'src/app/services/transaction/ITransactionService';
import { TransactionMockService } from 'src/app/services/transaction/transaction-mock.service';
import { SharedModule } from '../shared/shared.module';
import { CreateTransactionModal } from './components/create-clinic-modal/create-transaction-modal';
import { TransactionRoutingModule } from './transaction-routing.module';
import { TransactionComponent } from './transaction.component';

@NgModule({
  declarations: [
    CreateTransactionModal,
    TransactionComponent,
  ],
  imports: [
    TransactionRoutingModule,
    SharedModule
  ],
  providers: [
    {
      provide: ITransactionService,
      useClass: TransactionMockService
    },
  ]
})
export class TransactionModule { }
