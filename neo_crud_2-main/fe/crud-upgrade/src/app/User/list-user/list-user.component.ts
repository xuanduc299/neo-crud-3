import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { District } from 'src/app/Model/District';
import { Product } from 'src/app/Model/Product';
import { Province } from 'src/app/Model/Province';
import { Ward } from 'src/app/Model/Ward';
// import { User } from 'src/app/Model/User';
import { ServiceUserService } from 'src/app/Service/service-user.service';


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {
  p: any = 1;
  // user: any = [];
  product: any = [];
  lstUser: any = [];
  searchName: any;
  sort!: boolean;
  basicSelectedOption: number = 5;

  Provinces?: Province[];
  Districts?: District[];
  Wards?: Ward[];
  id?: any;

  // searchValue: string = "3";
  constructor(private router: Router, private service: ServiceUserService) { }

  public add(): void {
    this.router.navigate(["add-user"]);
  }


  ngOnInit(): void {
    this.getUsers();
    this.getProvince();
    this.getDistricts();
    this.getAllWards();
  }

  getUsers() {
    this.service.getUser().subscribe((data: any) => {
      this.product = Object.values(data);
      this.product = this.product[0]
      console.log("aaaa => " + this.product);
    });
  }

  getByName() {
    console.log(this.searchName);
    this.service.getByName(this.searchName).subscribe(data => {
      console.log("thành công", this.searchName);
      this.product = Object.values(data);
      this.product = this.product[0];
    }, error => {
      console.log("lỗi", error);
    });
  }

  checkSearch() {
    if (this.searchName == "") {
      this.getUsers();
    } else {
      this.getByName();
    }
  }


  updateUser(product: Product) {
    localStorage.setItem("id", product.id.toString());
    console.log(product.id);
    this.router.navigate(["edit-user"]);
  }

  deleteUser(product: Product) {
    this.service.deleteUser(product).subscribe(data => {
      this.product = this.product!.filter((p: any) => p !== product);

      alert("delete successfull")
    })
  }


  searchUser() {
    let id = Number(localStorage.getItem("id") || "");
    this.service.getUserId(id)
      .subscribe(data => {
        this.product = Object.values(data);
        this.product = this.product[0];
        //   this.user = Object.values(data);
        // this.user = this.user[0]
      })
  }

  courseCountRadioButton: string = 'All';
  searchText: string = '';

  onFilterRadioButtonChanged(data: string) {
    this.courseCountRadioButton = data;
    //console.log(this.courseCountRadioButton);
  }

  onSearchTextEntered(searchValue: string) {
    this.searchText = searchValue;
    //console.log(this.searchText);
  }

  sortName() {
    this.sort = !this.sort;
    if (this.sort) {
      this.product.sort((a: any, b: any) => a.name.localeCompare(b.name));
    } else {
      this.product.sort((a: any, b: any) => b.name.localeCompare(a.name));
    }
  }

  sortQuantity() {
    this.sort = !this.sort;
    if (this.sort) {
      this.product.sort((a: any, b: any) => a.quantity - b.quantity);
    } else {
      this.product.sort((a: any, b: any) => b.quantity - a.quantity);
    }
  }

  getProvince() {
    this.service.getProvince().subscribe(data => {
      this.Provinces = data;

    });
  }
  getDistricts() {
    this.service.getDistrict().subscribe(data => {
      this.Districts = data;

    });
  }
  getAllWards() {
    this.service.getWard().subscribe(data => {
      this.Wards = data;

    });
  }

  /////




}
