import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'short'
})
export class ShortPipe implements PipeTransform {

  transform(value: any,limit:any): any {
    if(value.length>limit){
      return value.substr(0,limit)+" ..."
    }
    return value;
    
  }

}
