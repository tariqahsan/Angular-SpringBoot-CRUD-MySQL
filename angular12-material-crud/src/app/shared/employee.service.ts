import { Injectable } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AngularFireDatabase, AngularFireList } from'@angular/fire/database';
import { FirebaseOperation } from '@angular/fire/database/interfaces';
import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Employee } from './Employee';
import { EmployeeModel } from './EmployeeModel';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8686/api/v1/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private dbPath = '/employees';
  employeeList!: AngularFireList<Employee>;

  // For Firebase consructor
  // constructor(private firebase: AngularFireDatabase) {
  //   this.employeeList = firebase.list(this.dbPath);
  // }

  // Constructor for both Firebase and HttpClient
  constructor(private firebase: AngularFireDatabase, private http: HttpClient) {
    this.employeeList = firebase.list(this.dbPath);
  }

  // For MySQL constructor
  //constructor(private http: HttpClient) { }

  //constructor(private firebase: AngularFireDatabase) { }

  //employeeList! : AngularFireList<any>;

  //employee: Employee = new Employee();

  form: FormGroup = new FormGroup({
    $key: new FormControl(null),
    fullName: new FormControl('', Validators.required),
    email: new FormControl('', Validators.email),
    mobile: new FormControl('', [Validators.required, Validators.minLength(10)]),
    city: new FormControl(''),
    gender: new FormControl('1'),
    department: new FormControl(0),
    hireDate: new FormControl(''),
    isPermanent: new FormControl(false)
  });

  initializeFormGroup() {
    console.log("Reseting form fields");
      this.form.setValue({
      $key: null,
      fullName: '',
      email: '',
      mobile: '',
      city: '',
      gender: '1',
      department: 0,
      hireDate: '',
      isPermanent: false
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
  // addEmployee(employee : EmployeeModel) : void{
  //   this.employeeList.push(employee);
  // }
  addEmployee(employee : Employee): any {
      console.log(employee);
      this.employeeList.push({
              fullName: employee.fullName,
              email: employee.email,
              mobile: employee.mobile,
              city: employee.city,
              gender: employee.gender,
              department: employee.department,
              hireDate: employee.hireDate,
              isPermanent: employee.isPermanent
            })
      //return this.employeeList.push(empl);
      //this.employeeList.push(employee);
    }
    //this.employeeList.push(employee);

  // For HttpClient CRUD
  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(baseUrl);
  }

  get(id: any): Observable<Employee> {
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

  findByTitle(title: any): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${baseUrl}?title=${title}`);
  }
}
  /*
  *list: AngularFireList<any>;
    createcontact:Contact = new Contact();
      constructor(private firebase:AngularFireDatabase) { } 
      insertdata(contact: Contact) {
    // here I get my data in console
            console.log(contact);
            this.list = this.firebase.list('/lists');
            if (contact) {
             this.list.push({
              name: contact.name,
              email:contact.email,
              phoneno:contact.phoneno,
              notes:contact.notes,
              address:contact.address,
              relation:contact.relation 
            });
          }
        }
  */

//   insertEmployee(employee: { fullName: string; email: string; mobile: string; city: string; gender: boolean; department: string; hireDate: string; isPermanent: boolean; }) {
//     console.log("Employee Full Name : " + employee.fullName);
//     this.employeeList.push({
//       fullName: employee.fullName,
//       email: employee.email,
//       mobile: employee.mobile,
//       city: employee.city,
//       gender: employee.gender,
//       department: employee.department,
//       hireDate: employee.hireDate,
//       isPermanent: employee.isPermanent
//     })
//   }
//   updateEmployee(employee: { $keys: string; fullName: any; email: any; mobile: any; city: any; gender: any; department: any; hireDate: any; isPermanent: any; }) {
//     this.employeeList.update(employee.$keys,{
//       fullName: employee.fullName,
//       email: employee.email,
//       mobile: employee.mobile,
//       city: employee.city,
//       gender: employee.gender,
//       department: employee.department,
//       // tslint:disable-next-line: triple-equals
//       // hireDate: employee.hireDate == '' ? '' : this.datePipe.transform(employee.hireDate, 'yyyy-MM-dd'),
//       hireDate: employee.hireDate,
//       isPermanent: employee.isPermanent
//     });

//     // deleteEmployee($keys: any) {
//     //   this.employeeList.remove($keys);
//     // }
//   }
// }

function $keys($keys: any) {
  throw new Error('Function not implemented.');
}
function deleteEmployee($key: any, string: any) {
  throw new Error('Function not implemented.');
}

