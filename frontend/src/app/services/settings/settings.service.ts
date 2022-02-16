import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Filter } from 'src/app/models/Filter';
import { Setting } from 'src/app/models/Setting';
import { environment } from 'src/environments/environment';
import { ISettingService } from './ISettingService';

@Injectable({
  providedIn: 'root'
})
export class SettingsService extends ISettingService {

  protected BASE_URL = environment.BASE_URL+ '/api/v1';
  
  constructor(
    private http: HttpClient,
    private notificationService: MatSnackBar
  ) { 
    super()
  }

  getData(): Observable<Setting[]> {
    return this.http.get<Setting[]>(`${this.BASE_URL}/settings`).pipe(
      catchError((error) => {
        this.notificationService.open(error.error.message, 'Aceptar');
        throw error;
      })
    );
  }

  getDataById(id: any): Observable<Setting> {
    return this.http.get<Setting>(`${this.BASE_URL}/settings/${id}`);
  }

  getDataFiltered(filters: Filter[]): Observable<Setting[]> {
    let filterQuery = Filter.encodeFilters(filters);
    return this.http
    .get<Setting[]>(`${this.BASE_URL}/settings?${filterQuery}`)
    .pipe(
      catchError((error) => {
        this.notificationService.open(error.error.message, 'Aceptar');
        throw error;
      })
    );
  }

  saveData(data: Setting, id: string): Observable<void> {
    return this.http
      .put<void>(`${this.BASE_URL}/settings/${id}`, data)
      .pipe(
        catchError((error) => {
          this.notificationService.open(error.error.message, 'Aceptar');
          throw error;
        })
      );
  }
}
