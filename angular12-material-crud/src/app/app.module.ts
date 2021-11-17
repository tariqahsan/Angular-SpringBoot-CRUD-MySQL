import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeComponent } from './employees/employee/employee.component';
import { MaterialModule } from './material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from './shared/employee.service';
import { DepartmentService } from './shared/department.service';
import { PinRequestService } from './shared/pin-request.service';
import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { environment } from '../environments/environment';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './users/user/user.component';
import { UserListComponent } from './users/user-list/user-list.component';
import { PinRequestsComponent } from './pin-requests/pin-requests.component';
import { PinRequestComponent } from './pin-requests/pin-request/pin-request.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeesComponent,
    EmployeeComponent,
    UsersComponent,
    UserComponent,
    UserListComponent,
    PinRequestsComponent,
    PinRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireDatabaseModule,
    HttpClientModule
  ],
  providers: [EmployeeService, DepartmentService, PinRequestService],
  bootstrap: [AppComponent],
  entryComponents: [EmployeeComponent]
})
export class AppModule { }

