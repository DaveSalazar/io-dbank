import { Observable } from "rxjs";
import { Account } from "src/app/models/Account";

export abstract class IAccountService {  
  abstract createAccount(): Observable<void>;
  abstract getData(): Observable<Account[]>;
}