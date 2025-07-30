import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDepartemmentComponent } from './liste-departemment.component';

describe('ListeDepartemmentComponent', () => {
  let component: ListeDepartemmentComponent;
  let fixture: ComponentFixture<ListeDepartemmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListeDepartemmentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeDepartemmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
