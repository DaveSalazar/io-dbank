import { Observable } from "rxjs";
import { Transaction } from "src/app/models/Transaction";

export abstract class ITransactionService {  
  abstract getData(): Observable<Transaction[]>;
}