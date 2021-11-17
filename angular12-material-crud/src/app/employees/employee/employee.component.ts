import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { map, tap } from 'rxjs/operators';
import { Department } from 'src/app/shared/Department';
import { DepartmentService } from 'src/app/shared/department.service';
import { EmployeeService } from 'src/app/shared/employee.service';
import { from, Observable } from 'rxjs';
import { NotificationService } from 'src/app/shared/notification.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public service: EmployeeService, public departmentService: DepartmentService, public notificationService: NotificationService, public _http: HttpClient) { }

  submitted = false;

  //@Input() departments: Department[] = [];


 
  // departments = [
  //   {id: 1, value: 'Deparment #1'},
  //   {id: 2, value: 'Deparment #2'},
  //   {id: 3, value: 'Deparment #3'}
  // ];

  // ngOnInit(): void {
  // }

  selected = null;
  users$: Observable<any> | undefined;
  departments$ ? : Observable<Department[]>;

  // ngOnInit() {
  //   this.users$ = this._http
  //     .get('https://randomuser.me/api?page=1&results=5&seed=abc')
  //     .pipe(
  //       map((data: any) => data.results),
  //       tap(data => (this.selected = data[0]))
  //     );
  // }

  // ngOnInit() {
  //   this.users$ = this._http
  //     .get('http://localhost:8686/api/v1/departments')
  //     .pipe(
  //       map((data: any) => data.results),
  //       tap(data => (this.selected = data[0]))
  //     );
  // }

  ngOnInit() {
    this.departments$ = this.departmentService.getAll();
    console.log("LIST OF DEPARMENTS : " + this.departments$);
  }

//   ngOnInit() {
//     // Create an Observable out of a promise
// const departments  = from(fetch('http://localhost:8686/api/v1/departments'));
// // Subscribe to begin listening for async result
// departments.subscribe({
//   next(response) { console.log(response); },
//   error(err) { console.error('Error: ' + err); },
//   complete() { console.log('Completed'); }
// });
//   }

  onClear() {
    this.service.form.reset();
    this.service.initializeFormGroup();
  }

  onSubmit() {
    if (this.service.form.valid) {
      //this.service.insertEmployee(this.service.form.value);

      // For Firebase
      this.service.addEmployee(this.service.form.value);
      console.log("department --->  " + this.service.form.value.department);
      const data = {
        // Selective fields
        fullName: this.service.form.value.fullName,
        email: this.service.form.value.email,
        department: this.service.form.value.department
      };

      // For MySQL
      this.service.create(data).subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });

      this.service.form.reset();
      //this.service.initializeFormGroup();
      this.notificationService.success(':: Submitted successfully');
    }
  }

}

interface departments {
  id: number,
  name: string
}
