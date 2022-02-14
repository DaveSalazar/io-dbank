export abstract class IAuthService {
    
  abstract login(): void;

  abstract logout(): void;

  abstract isLoggedIn(): boolean;

}