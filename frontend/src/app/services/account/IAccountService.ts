import { Observable } from "rxjs";

export abstract class IAccountService {  
  abstract checkAccount(): Observable<void>;
}