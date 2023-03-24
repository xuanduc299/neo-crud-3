import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListUserComponent } from './User/list-user/list-user.component';
import { AddUserComponent } from './User/add-user/add-user.component';
import { EditUserComponent } from './User/edit-user/edit-user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ServiceUserService } from './Service/service-user.service';
import { HttpClientModule } from '@angular/common/http';
import { SearchComponent } from './User/search/search.component';
import { StudentFilterPipePipe } from './student-filter-pipe.pipe';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from 'src/libs/shared/shared.module';
import { NgxPaginationModule } from 'ngx-pagination';
@NgModule({
  declarations: [
    AppComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent,
    SearchComponent,
    StudentFilterPipePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SharedModule,
    ReactiveFormsModule,
    NgxPaginationModule,
  ],
  providers: [ServiceUserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
