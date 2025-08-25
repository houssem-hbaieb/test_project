import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutPrestataireComponent } from './ajout-prestataire.component';

describe('AjoutPrestataireComponent', () => {
  let component: AjoutPrestataireComponent;
  let fixture: ComponentFixture<AjoutPrestataireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AjoutPrestataireComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AjoutPrestataireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
