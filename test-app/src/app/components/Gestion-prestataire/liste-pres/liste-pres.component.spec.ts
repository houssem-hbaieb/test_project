import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListePresComponent } from './liste-pres.component';

describe('ListePresComponent', () => {
  let component: ListePresComponent;
  let fixture: ComponentFixture<ListePresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListePresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListePresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
