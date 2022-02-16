import { Observable } from "rxjs";
import { Filter } from "src/app/models/Filter";
import { Setting } from "src/app/models/Setting";

export abstract class ISettingService {  
  abstract getData(): Observable<Setting[]>;

  abstract getDataById(id): Observable<Setting>;
    
  abstract getDataFiltered(filters: Filter[]): Observable<Setting[]>;
  
  abstract saveData(data: Setting, id: string): Observable<void>;
}