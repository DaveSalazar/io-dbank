import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
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


  checkAccount(): Observable<void> {
    return this.http
    .post<void>(`${this.BASE_URL}/accounts/check`, {})
    .pipe(
      catchError((error) => {
        this.notificationService.open(error.error.message, 'Aceptar');
        throw error;
      })
    );
  }
}