import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../Model/Product';
import { User } from '../Model/User';

@Injectable({
  providedIn: 'root'
})
export class ServiceUserService {

  constructor(private http: HttpClient) { }

  Url = "http://localhost:8082/product";

  searchText: string = '';

  // getUser(): Observable<User[]> {
  //   return this.http.get<User[]>(this.Url);
  // }

  // CreateUser(user: User): Observable<Object> {
  //   return this.http.post<User[]>(this.Url, user);
  //   // return this.http.post(`${this.Url}`, Personal);
  // }
  // getUserId(id: any) {
  //   return this.http.get<User>(this.Url + "/" + id);
  // }
  // updateUser(user: User) {
  //   return this.http.put<User>(this.Url, user);
  // }

  // deleteUser(user: User) {
  //   return this.http.delete<User[]>(this.Url + "/" + user.id);
  // }

  // onSearchTextEntered(searchValue: string) {
  //   this.searchText = searchValue;
  //   //console.log(this.searchText);
  // }

  getUser(): Observable<Product[]> {
    return this.http.get<Product[]>(this.Url + "/");
  }

  CreateUser(product: Product): Observable<Object> {
    return this.http.post<Product[]>(this.Url + "/add", product);
    // return this.http.post(`${this.Url}`, Personal);
  }
  getUserId(id: any) {
    return this.http.get<Product>(this.Url + "/" + id);
  }
  // updateUser(product: Product) {
  //   return this.http.put<Product[]>(this.Url, product);
  // }

  updateUser(id: any, product: any): Observable<Object> {
    return this.http.put(`${this.Url}/${id}`, product);
  }

  deleteUser(product: Product) {
    return this.http.delete<Product[]>(this.Url + "/" + product.id);
  }

  onSearchTextEntered(searchValue: string) {
    this.searchText = searchValue;
    //console.log(this.searchText);
  }

  getByName(searchName: any): Observable<any> {
    return this.http.get(`${this.Url}/search/${searchName}`);
  }

  // getProvinces(): Observable<any> {
  //   return this.http.get(`https://provinces.open-api.vn/api/`);
  // }
  // getDistricts(id: number): Observable<any> {
  //   return this.http.get(`https://provinces.open-api.vn/api/p/${id}?depth=2`);
  // }
  // getAllDistricts(): Observable<any> {
  //   return this.http.get(`https://provinces.open-api.vn/api/d`);
  // }
  // getVillage(): Observable<any> {
  //   return this.http.get(`https://provinces.open-api.vn/api/w`);
  // }




}
