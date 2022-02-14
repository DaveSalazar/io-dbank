import { Injectable } from '@angular/core';
import { BehaviorSubject, of } from 'rxjs';
import { Observable } from 'rxjs';
import { Profile } from 'src/app/models/Profile';
import { User } from 'src/app/models/User';
import { IProfileService } from './IProfileService';

@Injectable({
  providedIn: 'root'
})
export class ProfileMockService implements IProfileService {

  private profile: BehaviorSubject<User> = new BehaviorSubject(null)

  constructor() { }

  saveProfile(profile: Profile): Observable<void> {
    let user = this.profile.getValue()
    user.profile = profile
    this.profile.next(user)
    return of()
  }
  
  getProfile(): Observable<User> {
    return this.profile.asObservable()
  }
}
