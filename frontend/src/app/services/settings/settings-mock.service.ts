import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { Filter } from 'src/app/models/Filter';
import { Setting } from 'src/app/models/Setting';
import { ISettingService } from './ISettingService';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SettingsMockService extends ISettingService {

  private data: BehaviorSubject<Setting[]> = new BehaviorSubject([]);

  constructor() {
    super();
  }
  
  getData(): Observable<Setting[]> {
    return this.data.asObservable()
  }

  getDataById(id: any): Observable<Setting> {
    return this.data.asObservable().pipe(map(data => data.find(setting => setting.id === id)))
  }

  getDataFiltered(filters: Filter[]): Observable<Setting[]> {
    throw new Error('Method not implemented.');
  }

  saveData(data: Setting, id: string): Observable<void> {
    let currentData = this.data.getValue();
    const element = currentData.find(el => el.id === id)
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
