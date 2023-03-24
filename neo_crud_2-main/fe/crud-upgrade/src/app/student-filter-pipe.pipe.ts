import { Pipe, PipeTransform } from '@angular/core';
import { User } from './Model/User';

@Pipe({
  name: 'studentFilterPipe'
})
export class StudentFilterPipePipe implements PipeTransform {

  transform(list: User[], searchText: string): any {
    if (!list)
      return [];
    if (!searchText)
      return list;
    searchText = searchText.toLocaleLowerCase();

    list = list.filter(s => {
      return s.name?.toLocaleLowerCase().includes(searchText);
    });
    return list;

  }

}
