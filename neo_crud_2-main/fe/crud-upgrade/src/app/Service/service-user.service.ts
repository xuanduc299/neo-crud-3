import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Product } from '../Model/Product';

@Injectable({
  providedIn: 'root'
})
export class ServiceUserService {

  constructor(private http: HttpClient) { }

  Url = "http://localhost:8082/product";

  searchText: string = '';

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
  ////
  // getProvince(): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/p/");
  // }
  // getProvinceById(id: any): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/p/" + id);
  // }

  // getDistrict(): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/d/");
  // }

  // getDistrictById(id: any): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/d/" + id);
  // }

  // getWard(): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/w/");
  // }

  // getWardById(id: any): Observable<any> {
  //   return this.http.get("https://provinces.open-api.vn/api/w/" + id);
  // }


  getProvince(): Observable<any> {
    return this.http.get("http://localhost:8082/province/");
  }
  getDistrict(): Observable<any> {
    return this.http.get("http://localhost:8082/district/");
  }
  getWard(): Observable<any> {
    return this.http.get("http://localhost:8082/ward/");
  }

}
