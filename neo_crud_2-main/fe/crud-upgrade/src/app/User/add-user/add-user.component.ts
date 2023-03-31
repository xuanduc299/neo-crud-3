import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { District } from 'src/app/Model/District';
import { Product } from 'src/app/Model/Product';
import { Province } from 'src/app/Model/Province';
import { Ward } from 'src/app/Model/Ward';
import { ServiceUserService } from 'src/app/Service/service-user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})

export class AddUserComponent implements OnInit {
  product: Product = new Product();
  showAlert = false;
  submitted = false;

  Provinces?: Province[];
  Districts?: District[];
  Wards?: Ward[];
  id?: any;
  constructor(private fb: FormBuilder, private router: Router, private service: ServiceUserService) {
    this.formInit();
  }
  public form: any = FormGroup;

  ngOnInit(): void {
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


}
