import { Observable } from 'rxjs';
import { Profile } from 'src/app/models/Profile';
import { User } from 'src/app/models/User';

export abstract class IProfileService {
  
  abstract saveProfile(profile: Profile): Observable<void>;

  abstract getProfile(): Observable<User>;
}
