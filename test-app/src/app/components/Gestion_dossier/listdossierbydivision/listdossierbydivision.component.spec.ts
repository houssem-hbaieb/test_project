import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListdossierbydivisionComponent } from './listdossierbydivision.component';

describe('ListdossierbydivisionComponent', () => {
  let component: ListdossierbydivisionComponent;
  let fixture: ComponentFixture<ListdossierbydivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListdossierbydivisionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListdossierbydivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
