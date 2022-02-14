import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BehaviorSubject, Observable  } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Profile } from '../../models/Profile';
import { IProfileService } from './IProfileService';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private _profile: BehaviorSubject<Profile> = new BehaviorSubject(null);
  readonly profile = this._profile.asObservable();

  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient
  ) { 
    this._profile.next(this.getProfile());
  }

  saveProfile(profile: Profile): Observable<void> {
   
    return this.http.put<void>(`${environment.BASE_URL}/auth/login`, profile)
    .pipe(
      tap(() => {
        localStorage.setItem('profile', JSON.stringify(profile))
        this._profile.next(profile);
      }),
      catchError((error) => {
        this.snackBar.open(error.error.message, 'Aceptar', { duration: 2000 });
        throw error;
      })
    );
  }

  getProfile(): Profile {
    if(localStorage.getItem('profile')) {
      return JSON.parse(localStorage.getItem('profile'));
    }
    return null;
  }

  setSessionProfile(profile): void {
    localStorage.setItem('profile', JSON.stringify(profile));
  }

  deleteSessionProfile(): void {
    localStorage.removeItem('user');
    localStorage.removeItem('profile');
  }
}
