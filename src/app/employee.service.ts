import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:9090/employees';
  private baseUrl1 = 'http://localhost:9090/employeesById';



  constructor(private http: HttpClient) { }



  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  getEmployee(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl1}/${id}`);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
}
