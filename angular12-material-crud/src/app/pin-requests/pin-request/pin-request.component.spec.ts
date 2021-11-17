import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PinRequestComponent } from './pin-request.component';

describe('PinRequestComponent', () => {
  let component: PinRequestComponent;
  let fixture: ComponentFixture<PinRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PinRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PinRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
