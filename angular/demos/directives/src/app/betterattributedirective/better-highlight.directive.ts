import { Directive, ElementRef, HostBinding, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appBetterHighlight]'
})
export class BetterHighlightDirective {
  //using a Renderer to build a better attribute directive
  constructor(private elementRef:ElementRef,private renderer:Renderer2) { }
  ngOnInit(): void {
    //this.renderer.setStyle(this.elementRef.nativeElement,'background-color','yellow')
    this.backgroundColorVal=this.defaultColor
  }

  //using HostListener to listen to host events
  // @HostListener('mouseenter') mousehover(eventData:Event){
  //   this.renderer.setStyle(this.elementRef.nativeElement,'background-color','red')
  // }
  // @HostListener('mouseleave') mouseleave(eventData:Event){
  //   this.renderer.setStyle(this.elementRef.nativeElement,'background-color','transparent')
  // }

  //using HostBinding to bind to host properties(this can be used if we don't want to use Renderer2 and ElementRef)
  // @HostBinding('style.backgroundColor') backgroundColorVariable:string='transparent';
  // @HostListener('mouseenter') mousehover(eventData:Event){
  //   this.backgroundColorVariable='purple'
  // }
  // @HostListener('mouseleave') mouseleave(eventData:Event){
  //   this.backgroundColorVariable='cornflowerblue'
  // }

  // binding to directive properties
  @Input() defaultColor:string='transparent';
  @Input() highlightedColor:string='yellow';
  @HostBinding('style.backgroundColor') backgroundColorVal:string | undefined;

  @HostListener('mouseenter') mousehover(eventData:Event){
    this.backgroundColorVal=this.highlightedColor
  }
  @HostListener('mouseleave') mouseleave(eventData:Event){
    this.backgroundColorVal=this.defaultColor
  }

}
