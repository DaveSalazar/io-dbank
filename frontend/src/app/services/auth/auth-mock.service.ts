import { Injectable } from '@angular/core';
import { IAuthService } from './IAuthService';
@Injectable({
  providedIn: 'root',
})
export class AuthMockService extends IAuthService {

  loggedIn: boolean = false;

  login(): void {
    this.loggedIn = true
  }

  logout(): void {
    this.loggedIn = false
  }

  isLoggedIn(): boolean {
    return this.loggedIn
  }
  
}
