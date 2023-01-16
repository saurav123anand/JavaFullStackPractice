import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective {
  //using a Renderer to build a better attribute directive
  constructor(private elementRef:ElementRef,private renderer:Renderer2) { }
  ngOnInit(): void {
    this.renderer.setStyle(this.elementRef.nativeElement,'background-color','yellow')
  }

  //using HostListener to listen to host events
  

}
