import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'crud-upgrade';

  constructor(private router: Router) { }

  public list(): void {
    this.router.navigate(["list-user"]);
  }

}
