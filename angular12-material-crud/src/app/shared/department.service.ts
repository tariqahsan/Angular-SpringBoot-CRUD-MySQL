import { Injectable, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AngularFireDatabase, AngularFireList } from'@angular/fire/database';
import { FirebaseOperation } from '@angular/fire/database/interfaces';
import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Department } from './Department';
import { Observable, throwError } from 'rxjs';
//import { retry, catchError } from 'rxjs/operators';
import { map, tap } from "rxjs/operators";

// Define API
const apiURL = 'http://localhost:8686/api/v1/departments';

// const selected = null;
// users$: new Observable<any>();

@Injectable({
  providedIn: 'root'
})
export class DepartmentService implements OnInit {

  private dbPath = '/departments';
  departmentList!: AngularFireList<Department>;
  //array = [] as Department;
  //departments =  [] as Department;
  departments: Department[] | undefined;
  selected: any;
  users$: Observable<any> | undefined;

   // Constructor for both Firebase and HttpClient
   constructor(private firebase: AngularFireDatabase, private _http: HttpClient) {
    this.departmentList = firebase.list(this.dbPath);
    this.departmentList.snapshotChanges().subscribe(data => {
      this.departments = data.map(item => {
        return {
          $key: item.key,
          ...item.payload.val()
        };
      });
    });
   }

   getAll(): Observable<Department[]> {
    return this._http.get<Department[]>(apiURL);
  }

   getDepartmentObservables() {
       return this.departmentList.snapshotChanges()
   } 

   // HttpClient API get() method => Fetch employees list
  // getEmployees(): Observable<Department> {
  //   return this.http.get<Department>(this.apiURL + '/employees')
  //   .pipe(
  //     retry(1),
  //     catchError(this.handleError)
  //   )
  // }

  ngOnInit() {
    this.users$ = this._http
      .get('https://randomuser.me/api?page=1&results=5&seed=abc')
      .pipe(
        map((data: any) => data.results),
        tap(data => (this.selected = data[0]))
      );
  }
  
}
function retry(arg0: number): import("rxjs").OperatorFunction<any, unknown> {
  throw new Error('Function not implemented.');
}

