import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { District } from 'src/app/Model/District';
import { Product } from 'src/app/Model/Product';
import { Province } from 'src/app/Model/Province';
import { Ward } from 'src/app/Model/Ward';
import { ServiceUserService } from 'src/app/Service/service-user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})

export class EditUserComponent implements OnInit {
  product: any = new Product();
  showAlert = false;
  submitted = false;

  Provinces?: Province[];
  selectedProvince?: any;
  Districts?: District[];
  selectedDistrict?: any;
  Wards?: Ward[];
  selectedWard?: any;
  id?: any;


  constructor(private fb: FormBuilder, private router: Router, private service: ServiceUserService) { }
  public form: any = FormGroup;
  ngOnInit(): void {
    this.editUser(); this.formInit();
    this.getProvince();
    this.getDistricts();
    this.getAllWards();

  }

  private formInit() {
    this.form = this.fb.group({
      maSp: ['', [Validators.required]],
      name: ['', [Validators.required]],
      date: ['', [Validators.required]],
      product_width: ['', [Validators.required]],
      product_height: ['', [Validators.required]],
      color: ['', [Validators.required]],
      quantity: ['', [Validators.required]],
      brand: ['', [Validators.required]],
      material: ['', [Validators.required]],
      sectors: ['', [Validators.required]],
      province: ['', [Validators.required]],
      district: ['', [Validators.required]],
      ward: ['', [Validators.required]],
    });
  }

  get f(): { [key: string]: AbstractControl } {
    return this.form.controls;
  }


  editUser() {
    let id = String(localStorage.getItem("id") || "");
    this.service.getUserId(id)
      .subscribe(data => {
        this.product = Object.values(data);
        this.product = this.product[0];
      })
  }

  onSubmit() {
    this.service.updateUser(this.product.id, this.product).subscribe(data => {
      this.product = Object.values(data);
      // this.product = this.product[0];
      alert("eidt successfulll");
      this.router.navigate(["list-user"]);
    })
  }

  closeAlert() {
    this.showAlert = false;
  }


  getProvince() {
    this.service.getProvince().subscribe(data => {
      console.log("thành công", data);
      this.Provinces = data;
    }, error => {
      console.log("lỗi", error);
    });
  }
  getDistricts() {
    this.service.getDistrict().subscribe(data => {
      console.log("thành công", data);
      this.Districts = data;
    }, error => {
      console.log("lỗi", error);
    });
  }
  private getAllWards() {
    this.service.getWard().subscribe(data => {
      console.log("thành công", data);
      this.Wards = data;
    }, error => {
      console.log("lỗi", error);
    });
  }


  // public cities = [
  //   {
  //     city: 'Chọn thành phố!',
  //     district: [],
  //   },
  //   {
  //     city: 'Hà Nội',
  //     district: [
  //       'Ba Đình',
  //       'Bắc Từ Liêm',
  //       'Cầu Giấy',
  //       'Đống Đa',
  //       'Hà Đông',
  //       'Hoàn Kiếm',
  //       'Đan Phượng',
  //     ],
  //     village: [
  //       'Ba Đình',
  //       'Bắc Từ Liêm',
  //       'Cầu Giấy',
  //       'Đống Đa',
  //       'Hà Đông',
  //       'Hoàn Kiếm',
  //       'Đan Phượng',
  //     ],
  //   },
  //   {
  //     city: ' Hải Phòng',
  //     district: [
  //       'Hồng Bàng',
  //       'Lê Chân',
  //       'Ngô Quyền',
  //       'Kiến An',
  //       'Đồ Sơn',
  //       'Dương Kinh',
  //       'Hải An',
  //     ],
  //   },
  //   {
  //     city: 'DN',
  //     district: [
  //       'Thanh Khê',
  //       'Sơn Trà',
  //       'Hoà Vang',
  //       'Ngũ Hành Sơn',
  //       'Liên Chiểu',
  //       'Cẩm Lệ',
  //     ],
  //   },
  // ];

  // public _districts = [
  //   {
  //     district: 'Chọn Phường/Quận!',
  //     village: [],
  //   },
  //   {
  //     district: 'ba dinh',
  //     village: [
  //       'Ba Đình',
  //       'Bắc Từ Liêm',
  //       'Cầu Giấy',
  //       'Đống Đa',
  //       'Hà Đông',
  //       'Hoàn Kiếm',
  //       'Đan Phượng',
  //     ],
  //   },
  //   {
  //     district: 'Đan Phượng',
  //     village: [
  //       'Hồng Bàng',
  //       'Lê Chân',
  //       'Ngô Quyền',
  //       'Kiến An',
  //       'Đồ Sơn',
  //       'Dương Kinh',
  //       'Hải An',
  //     ],
  //   },
  //   {
  //     district: 'DN',
  //     village: [
  //       'Thanh Khê',
  //       'Sơn Trà',
  //       'Hoà Vang',
  //       'Ngũ Hành Sơn',
  //       'Liên Chiểu',
  //       'Cẩm Lệ',
  //     ],
  //   },
  // ];

  // public districts: string[] = ['quan/huyen'];
  // public villages: string[] = ['xa/lang'];

  // public changeCity(event: any) {
  //   const city = event.target.value;

  //   if (!city) {
  //     return;
  //   }
  //   this.districts = this.cities.find(data => data.city === city)?.district || [];

  //   // const district = event.target.value;

  //   // if (!district) {
  //   //   return;
  //   // }
  //   // this.villages = this._districts.find(data => data.district === district)?.village || [];
  //   // console.log(this.villages);
  // }

  // public changeDistrict(event: any) {
  //   const district = event.target.value;

  //   if (!district) {
  //     return;
  //   }
  //   this.villages = this._districts.find(data => data.district === district)?.village || [];

  // }



}
