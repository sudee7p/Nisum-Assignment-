interface User{
    name : string;
    email: string;
    isActive: boolean;
    phoneno?: string;
}
const newUser : User = {
    id: 1,
    name: "john doe",
    email: "johndoe@gmail.com",
    isActive: true
};