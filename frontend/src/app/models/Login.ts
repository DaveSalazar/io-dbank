export interface ILogin {
    id: string;
    email: string;
    password: string;
}

export class Login implements ILogin {
    readonly id: string;
    readonly email: string;
    readonly password: string;

    constructor(
        id: string,
        email: string,
        password: string
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
}