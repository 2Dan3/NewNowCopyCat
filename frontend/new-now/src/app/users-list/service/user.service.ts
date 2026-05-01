import { Injectable } from '@angular/core';
import { User } from '../model/user.model';

const USERS = [
  {"_id":1, "username":"petar123", "password":"123","email":"pera@gmail.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"peki98", "role":"USER"},
  {"_id":2, "username":"marko456", "password":"123","email":"marko@gmail.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"markoomare", "role":"USER"},
  {"_id":3, "username":"milica982", "password":"123","email":"milica982@yahoo.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"millicaa982", "role":"ADMIN"},
  {"_id":4, "username":"ivana015", "password":"123","email":"ivanaa015@yahoo.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"ivance015", "role":"ADMIN"},
  {"_id":5, "username":"jovana381", "password":"123","email":"jovanaa381@gmail.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"jovannna381", "role":"USER"},
  {"_id":6, "username":"tara041", "password":"123","email":"taraa041@gmail.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"tara4", "role":"USER"},
  {"_id":7, "username":"stefan351", "password":"123","email":"stefi351@yahoo.com","avatar":"pathToImgOnDisc","registration_date":Date(),"description":"I'm a ... I work as a ... part-time & as a ... part-time as well as being a ... I enjoy doing ... , but also the ...","display_name":"stefii015", "role":"USER"}
]

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userList: User[] = [];

  constructor() {
    for(let u of USERS) {
      this.userList.push(new User(u));
    }

   }

   getAll() :User[] {
    return this.userList;
   }

   findById(user_id: string|number) :User {
    for(let userr of this.userList){
      if (userr._id == user_id) {
        return userr;
      }
    }
    return new User();
    // TODO*: or return sth 
    // along the lines of UserNotFoundException
   }

   findByUsername(username: string) :User {
    for(let userr of this.userList){
      if (userr.email === username) {
        return userr;
      }
    }
    return new User();
    // TODO*: or return sth 
    // along the lines of UserNotFoundException
   }

}