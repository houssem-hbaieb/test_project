import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterDivisionComponent } from './ajouter-division.component';

describe('AjouterDivisionComponent', () => {
  let component: AjouterDivisionComponent;
  let fixture: ComponentFixture<AjouterDivisionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AjouterDivisionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjouterDivisionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
