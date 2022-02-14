import { IProfile } from "./Profile";

export interface IUser {
    id: string;
    email: string;
    profile: IProfile;
}

export class User implements IUser {
    
    readonly id: string;
    readonly email: string;
    profile: IProfile;

    constructor(
        id: string,
        email: string,
        profile: IProfile
    ) {
        this.id = id;
        this.email = email;
        this.profile = profile;
    }
    
}