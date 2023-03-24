import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { District } from 'src/app/Model/District';
import { Product } from 'src/app/Model/Product';
import { Province } from 'src/app/Model/Province';
import { ServiceUserService } from 'src/app/Service/service-user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})

export class AddUserComponent implements OnInit {
  product: Product = new Product();
  showAlert = false;

  constructor(private fb: FormBuilder, private router: Router, private service: ServiceUserService) {
    this.formInit();
  }
  public form: any = FormGroup;

  ngOnInit(): void {

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
      village: ['', [Validators.required]],
    });
  }

  // get name() { return this.myForm.get('name'); }
  // get email() { return this.myForm.get('email'); }
  // get pasword() { return this.myForm.get('pasword'); }
  savePersonal() {
    this.service.CreateUser(this.product).subscribe(data => {
      console.log(data);
      this.goToUserList();
    },
      error => console.log(error));
  }


  goToUserList() {
    this.router.navigate(['/list-user']);
  }

  onSubmit() {
    console.log(this.product);
    this.savePersonal();
  }

  closeAlert() {
    this.showAlert = false;
  }

  // get Studentranch(){  
  //   return this.formInit.get('student_branch');  
  // }  

  public cities = [
    {
      city: 'Chọn thành phố!',
      district: [],
    },
    {
      city: 'Hà Nội',
      district: [
        'Ba Đình',
        'Bắc Từ Liêm',
        'Cầu Giấy',
        'Đống Đa',
        'Hà Đông',
        'Hoàn Kiếm',
        'Đan Phượng',
      ],
      village: [
        'Ba Đình',
        'Bắc Từ Liêm',
        'Cầu Giấy',
        'Đống Đa',
        'Hà Đông',
        'Hoàn Kiếm',
        'Đan Phượng',
      ],
    },
    {
      city: ' Hải Phòng',
      district: [
        'Hồng Bàng',
        'Lê Chân',
        'Ngô Quyền',
        'Kiến An',
        'Đồ Sơn',
        'Dương Kinh',
        'Hải An',
      ],
    },
    {
      city: 'DN',
      district: [
        'Thanh Khê',
        'Sơn Trà',
        'Hoà Vang',
        'Ngũ Hành Sơn',
        'Liên Chiểu',
        'Cẩm Lệ',
      ],
    },
  ];

  public _districts = [
    {
      district: 'Chọn Phường/Quận!',
      village: [],
    },
    {
      district: 'ba dinh',
      village: [
        'Ba Đình',
        'Bắc Từ Liêm',
        'Cầu Giấy',
        'Đống Đa',
        'Hà Đông',
        'Hoàn Kiếm',
        'Đan Phượng',
      ],
    },
    {
      district: 'Đan Phượng',
      village: [
        'Hồng Bàng',
        'Lê Chân',
        'Ngô Quyền',
        'Kiến An',
        'Đồ Sơn',
        'Dương Kinh',
        'Hải An',
      ],
    },
    {
      district: 'DN',
      village: [
        'Thanh Khê',
        'Sơn Trà',
        'Hoà Vang',
        'Ngũ Hành Sơn',
        'Liên Chiểu',
        'Cẩm Lệ',
      ],
    },
  ];

  public districts: string[] = ['quan/huyen'];
  public villages: string[] = ['xa/lang'];

  public changeCity(event: any) {
    const city = event.target.value;

    if (!city) {
      return;
    }
    this.districts = this.cities.find(data => data.city === city)?.district || [];

    // const district = event.target.value;

    // if (!district) {
    //   return;
    // }
    // this.villages = this._districts.find(data => data.district === district)?.village || [];
    // console.log(this.villages);
  }

  public changeDistrict(event: any) {
    const district = event.target.value;

    if (!district) {
      return;
    }
    this.villages = this._districts.find(data => data.district === district)?.village || [];

  }


}
