import { Injectable } from '@angular/core';
import { OAuthService } from 'angular-oauth2-oidc';
import { IAuthService } from './IAuthService';

@Injectable({
  providedIn: 'root',
})
export class AuthService implements IAuthService {
  
  constructor(private oauthService: OAuthService) { }

  login(): void {
    this.oauthService.initImplicitFlowInternal();
  }

  logout(): void {
    this.oauthService.logOut();
  }

  isLoggedIn(): boolean {
    return this.oauthService.hasValidIdToken() && this.oauthService.hasValidAccessToken();
  } 
  
}
