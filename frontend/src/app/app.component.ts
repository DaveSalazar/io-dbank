import { Component } from '@angular/core';
import { OAuthService, AuthConfig, NullValidationHandler } from 'angular-oauth2-oidc';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'Administration';

  constructor(private oauthService: OAuthService) {
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
          
        }
      });
  }

  getclientId() {    
    return 'frontend';
  }
}
