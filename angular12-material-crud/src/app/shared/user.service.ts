import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AngularFireDatabase, AngularFireList } from'@angular/fire/database';
import { FirebaseOperation } from '@angular/fire/database/interfaces';
import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8686/api/v1/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private dbPath = '/employees';
  employeeList!: AngularFireList<User>;

  // For Firebase consructor
  // constructor(private firebase: AngularFireDatabase) {
  //   this.employeeList = firebase.list(this.dbPath);
  // }

 
  // For MySQL constructor
  constructor(private http: HttpClient) { }

  //constructor(private firebase: AngularFireDatabase) { }

  //employeeList! : AngularFireList<any>;

  //user: User = new User();

  form: FormGroup = new FormGroup({
    $key: new FormControl(null),
    firstName: new FormControl('', Validators.required),
    middleName: new FormControl(''),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', Validators.email),
    phone: new FormControl('', [Validators.required, Validators.minLength(10)]),
    address: new FormGroup({
      street1: new FormControl(''),
      street2: new FormControl(''),
      city: new FormControl(''),
      state: new FormControl(''),
      zip5: new FormControl(''),
      zip4: new FormControl('')
    })
  });

  initializeFormGroup() {
    console.log("Reseting form fields");
      this.form.setValue({
      $key: null,
      firstName: '',
      middleName: '',
      lastName: '',
      email: '',
      phone: '',
      city: '',
      state: '',
      zip5: '',
      zip4: ''
    })
  }

  // For Firebase
  // getEmployees() {
  //   this.employeeList = this.firebase.list('employees');
  //   return this.employeeList.snapshotChanges();
  // }

  // To prevent the error -
  // angularfire error: push failed: value argument contains an invalid key ($key) in property 'employees'. keys must be non-empty strings and can't contain ".", "#", "$", "/", "[", or "]" site:stackoverflow.com
  // omitted $key field value in inserting value which is getting auto generated
  // addEmployee(user : EmployeeModel) : void{
  //   this.employeeList.push(user);
  // }
  addEmployee(user : User): any {
      console.log(user);
      this.employeeList.push({
              firstName: user.firstName,
              middleName: user.middleName,
              lastName: user.lastName,
              email: user.email,
              phone: user.phone
              // city: user.city,
              // state: user.state,
              // zip5: user.zip5,
              // zip4: user.zip4
            })
  
    }

  // For HttpClient CRUD
  getAll(): Observable<User[]> {
    return this.http.get<User[]>(baseUrl);
  }

  get(id: any): Observable<User> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    console.log(`${baseUrl}/add`)
    console.log(data)
    return this.http.post(`${baseUrl}/add`, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<User[]> {
    return this.http.get<User[]>(`${baseUrl}?title=${title}`);
  }
}
 
function $keys($keys: any) {
  throw new Error('Function not implemented.');
}
function deleteEmployee($key: any, string: any) {
  throw new Error('Function not implemented.');
}

