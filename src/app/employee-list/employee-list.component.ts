import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../employee.service";
import {Observable} from "rxjs";
import {Employee} from "../employee";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]> | undefined;
  constructor(private employeeService: EmployeeService,private router: Router) {}

  ngOnInit(): void {

    this.reloadData();
  }

  private reloadData() {
    this.employees = this.employeeService.getEmployeesList();

  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }

}
