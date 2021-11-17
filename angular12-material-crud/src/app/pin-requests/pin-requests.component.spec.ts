import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PinRequestsComponent } from './pin-requests.component';

describe('PinRequestsComponent', () => {
  let component: PinRequestsComponent;
  let fixture: ComponentFixture<PinRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PinRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PinRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
