import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBar} from '@angular/material/snack-bar';
import { MainModule } from './layouts/main/main.module';
import { HttpClientModule } from '@angular/common/http';
import { OAuthModule } from 'angular-oauth2-oidc';
import { environment } from 'src/environments/environment';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModule,
    HttpClientModule,
    BrowserAnimationsModule,
    OAuthModule.forRoot({
      resourceServer: {
          allowedUrls: [environment.BASE_URL],
          sendAccessToken: true
      }
    })
  ],

  providers: [
    MatSnackBar,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
