import { Observable } from "rxjs";
import { Transaction } from "src/app/models/Transaction";

export abstract class ITransactionService {  
  abstract saveData(data: Transaction): Observable<void>;
  abstract getData(): Observable<Transaction[]>;
}