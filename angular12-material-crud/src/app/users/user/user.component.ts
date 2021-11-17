import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { map, tap } from 'rxjs/operators';
import { Department } from 'src/app/shared/Department';
import { DepartmentService } from 'src/app/shared/department.service';
//import { UserService } from 'src/app/shared/user.service';
import { UserService } from 'src/app/shared/user.service';
import { from, Observable } from 'rxjs';
import { NotificationService } from 'src/app/shared/notification.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  constructor(public userService: UserService, public departmentService: DepartmentService, public notificationService: NotificationService, public _http: HttpClient) { }

  ngOnInit() {
    this.departments$ = this.departmentService.getAll();
    console.log("LIST OF DEPARMENTS : " + this.departments$);
  }

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
    this.userService.form.reset();
    this.userService.initializeFormGroup();
  }

  onSubmit() {
    if (this.userService.form.valid) {
      //this.userservice.insertEmployee(this.userservice.form.value);

      // For Firebase
      // this.userService.addEmployee(this.userService.form.value);
      // console.log("department --->  " + this.userService.form.value.department);
      const data = {
        // Selective fields
        firstName: this.userService.form.value.firstName,
        middleName: this.userService.form.value.middleName,
        lastName: this.userService.form.value.lastName,
        email: this.userService.form.value.email,
        phone: this.userService.form.value.phone,
        address: this.userService.form.value.address
        //department: this.userService.form.value.department
      };

      // For MySQL
      // this.userService.create(data).subscribe(
        this.userService.create(this.userService.form.value).subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });

      this.userService.form.reset();
      //this.userService.initializeFormGroup();
      this.notificationService.success(':: Submitted successfully');
    }
  }

}

interface departments {
  id: number,
  name: string
}

