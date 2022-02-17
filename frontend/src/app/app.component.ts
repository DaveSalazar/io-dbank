import { Component } from '@angular/core';
import { OAuthService, AuthConfig, NullValidationHandler } from 'angular-oauth2-oidc';
import { of } from 'rxjs';
import { concatMap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Filter } from './models/Filter';
import { IAccountService } from './services/account/IAccountService';
import { ISettingService } from './services/settings/ISettingService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'IO DBank';

  constructor(
    private oauthService: OAuthService, 
    private settingService: ISettingService,
    private accountService: IAccountService
    ) {
    this.configure()
  }

  authConfig: AuthConfig = {
    issuer:  environment.ISSUER,
    redirectUri: window.location.origin,
    clientId: this.getclientId(),
    responseType: 'code',
    scope: 'openid profile email offline_access',
    showDebugInformation: true,
  };

  configure(): void {
    this.oauthService.configure(this.authConfig);
    this.oauthService.tokenValidationHandler = new NullValidationHandler();
    this.oauthService.setupAutomaticSilentRefresh();
    this.oauthService.loadDiscoveryDocumentAndLogin()
      .then(() => {
        if (this.oauthService.getIdentityClaims()) {
          console.log(this.oauthService.getIdentityClaims())
          const idClaims = this.oauthService.getIdentityClaims();
          let filters: Filter[] = [
            {field: 'userId', value: (idClaims as any).sub , operator: '='}
          ]
          this.settingService.getDataFiltered(filters)
          .pipe(
            concatMap(res => {              
              if((res as []).length == 0) {
                return this.accountService.createAccount()
              } else {
                return of()
              }
            })
          )
          .subscribe(res => console.log)
        }
      });
  }

  getclientId() {    
    return 'frontend';
  }
}
