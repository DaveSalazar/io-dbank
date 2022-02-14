import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { IProfileService } from 'src/app/services/profile/IProfileService';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile = new Observable()

  constructor(private profileService: IProfileService) { }

  ngOnInit(): void {
    this.profile = this.profileService.getProfile()
  }
}
