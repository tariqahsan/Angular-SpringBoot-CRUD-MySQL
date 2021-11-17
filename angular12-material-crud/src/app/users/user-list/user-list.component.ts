import {AfterViewInit, Component, ViewChild, OnInit} from '@angular/core';
//import { User } from 'src/app/shared/User';
import { UserService } from 'src/app/shared/user.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {HttpClient} from '@angular/common/http';

import {MatPaginator} from '@angular/material/paginator';
import {MatSort, SortDirection} from '@angular/material/sort';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import { UserComponent } from '../user/user.component';

/**
 * @title Table retrieving data through HTTP
 */
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

// export class UserListComponent implements AfterViewInit {
  export class UserListComponent implements OnInit {
  
  displayedColumns: string[] = ['firstName', 'middleName', 'lastName', 'phone', 'email', 'actions'];
  exampleDatabase: ExampleHttpDatabase | null | undefined;
  dataSource = new MatTableDataSource<User>();

  data: User[] = [];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _httpClient: HttpClient, public service: UserService, private dialog: MatDialog,) {
    
  }

  ngOnInit() {
    this.service.getAll().subscribe(response => {

      this.dataSource = new MatTableDataSource(response);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
    //     this.dataSource = new MatTableDataSource(this.data);
    // this.dataSource.filterPredicate = (data, filter) => {
    //   return data.articolo.code.indexOf(filter) != -1;
    // }
        // this.dataSource.filterPredicate = (data, filter) => {
        //   return this.displayedColumns.some(ele => {
        //     return ele != 'actions' && data[ele].toLowerCase().indexOf(filter) != -1;
        //   });
        // };
    });
  }

  // ngOnInit() {
  //   this.service.getAll().subscribe(
  //     list => {
  //       let array = list.map(item => {
  //         return {
  //           $key: item.$key,
  //           ...item
  //         };
  //       });
  //       this.dataSource = new MatTableDataSource(array)
  //     }
  //   )
  // }

  // ngAfterViewInit() {
  //   this.exampleDatabase = new ExampleHttpDatabase(this._httpClient);

  //   // If the user changes the sort order, reset back to the first page.
  //   this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

  //   merge(this.sort.sortChange, this.paginator.page)
  //     .pipe(
  //       startWith({}),
  //       switchMap(() => {
  //         this.isLoadingResults = true;
  //         return this.exampleDatabase!.getRepoIssues(
  //             this.sort.active, this.sort.direction, this.paginator.pageIndex)
  //           .pipe(catchError(() => observableOf(null)));
  //       }),
  //       map(data => {
  //         // Flip flag to show that loading has finished.
  //         this.isLoadingResults = false;
  //         this.isRateLimitReached = data === null;

  //         if (data === null) {
  //           return [];
  //         }

  //         // Only refresh the result length if there is new data. In case of rate
  //         // limit errors, we do not want to reset the paginator to zero, as that
  //         // would prevent users from re-triggering requests.
  //         //this.resultsLength = data.total_count;
  //         return data;
  //       })
  //     ).subscribe(data => this.data = data);
  // }

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();

  //   if (this.dataSource.paginator) {
  //     this.dataSource.paginator.firstPage();
  //   }
  // }

  onCreate() {
    this.service.initializeFormGroup();
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = '70%';
    this.dialog.open(UserComponent, dialogConfig);
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

export interface User {
  $key?: string | null;
  firstName?:string;
  middleName?:string;
  lastName?:string;
  phone?:string;
  email?:string;
}

/** An example database that the data source uses to retrieve data for the table. */
export class ExampleHttpDatabase {
  constructor(private _httpClient: HttpClient) {}

    getRepoIssues(sort: string, order: SortDirection, page: number): Observable<User[]> {
    const href = 'http://localhost:8686/api/v1/users';
    const requestUrl =
        `${href}?q=repo:angular/components&sort=${sort}&order=${order}&page=${page + 1}`;
    return this._httpClient.get<User[]>(requestUrl);
  }
}