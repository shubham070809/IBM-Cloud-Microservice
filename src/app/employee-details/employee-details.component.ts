import { Component, OnInit } from '@angular/core';
import {Employee} from "../employee";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../employee.service";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  id: number=0;
  employee: Employee | undefined;

  constructor(private route: ActivatedRoute,private router: Router,
              private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();

    this.id = this.route.snapshot.params['id'];

    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      })
  }

  list(){
    this.router.navigate(['employees']);
  }

}
