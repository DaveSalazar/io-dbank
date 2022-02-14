import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { IProfileService } from 'src/app/services/profile/IProfileService';
import { ProfileMockService } from 'src/app/services/profile/profile-mock.service';
import { MaterialModule } from '../shared/material.module';
import { SharedModule } from '../shared/shared.module';
import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileComponent } from './profile.component';

@NgModule({
  declarations: [
    ProfileComponent
  ],
  imports: [
    ProfileRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    SharedModule
  ],
  providers: [
    {
      provide: IProfileService,
      useClass: ProfileMockService
    },
  ]
})
export class ProfileModule { }
