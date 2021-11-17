import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { map, tap } from 'rxjs/operators';
import { Department } from 'src/app/shared/Department';
import { DepartmentService } from 'src/app/shared/department.service';
import { PinRequestService } from 'src/app/shared/pin-request.service';
import { from, Observable } from 'rxjs';
import { NotificationService } from 'src/app/shared/notification.service';

@Component({
  selector: 'app-pin-request',
  templateUrl: './pin-request.component.html',
  styleUrls: ['./pin-request.component.css']
})
export class PinRequestComponent implements OnInit {
  constructor(public pinRequestService: PinRequestService, public notificationService: NotificationService) { }

  ngOnInit() {

  }

  submitted = false;

  selected = null;
  users$: Observable<any> | undefined;
  departments$?: Observable<Department[]>;

  onClear() {
    this.pinRequestService.form.reset();
    this.pinRequestService.initializeFormGroup();
  }

  // checkboxChange(checkboxValue: string) {
  //   this.pinRequestService.form.setValue(checkboxValue ? 'Y' : 'N', this.setValueOptions);
  // }
  // setValueOptions(arg0: string, setValueOptions: string) {
  //   throw new Error('Method not implemented.');
  // }

  onSubmit() {
    if (this.pinRequestService.form.valid) {

      // For MySQL
      this.pinRequestService.create(this.pinRequestService.form.value).subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });

      this.pinRequestService.form.reset();
      this.notificationService.success(':: Submitted successfully');
    }
  }

}

interface departments {
  id: number,
  name: string
}


