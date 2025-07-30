import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDivisionComponent } from './liste-division.component';

describe('ListeDivisionComponent', () => {
  let component: ListeDivisionComponent;
  let fixture: ComponentFixture<ListeDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListeDivisionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
