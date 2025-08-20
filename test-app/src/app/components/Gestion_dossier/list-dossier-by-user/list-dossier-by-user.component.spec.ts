import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDossierByUserComponent } from './list-dossier-by-user.component';

describe('ListDossierByUserComponent', () => {
  let component: ListDossierByUserComponent;
  let fixture: ComponentFixture<ListDossierByUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListDossierByUserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListDossierByUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
