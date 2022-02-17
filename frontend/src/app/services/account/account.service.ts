import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Account } from 'src/app/models/Account';
import { environment } from 'src/environments/environment';
import { IAccountService } from './IAccountService';

@Injectable({
  providedIn: 'root'
})
export class AccountService extends IAccountService{

  
  protected BASE_URL = environment.BASE_URL+ '/api/v1';

  constructor(
    private http: HttpClient,
    private notificationService: MatSnackBar
  ) { 
    super()
  }

  getData(): Observable<Account[]> {
    return this.http.get<Account[]>(`${this.BASE_URL}/accounts`).pipe(
      catchError((error) => {
        this.notificationService.open(error.error.message, 'Aceptar');
        throw error;
      })
    );
  }

  createAccount(): Observable<void> {
    return this.http
    .post<void>(`${this.BASE_URL}/accounts/create`, {})
    .pipe(
      catchError((error) => {
        this.notificationService.open(error.error.message, 'Aceptar');
        throw error;
      })
    );
  }
}
