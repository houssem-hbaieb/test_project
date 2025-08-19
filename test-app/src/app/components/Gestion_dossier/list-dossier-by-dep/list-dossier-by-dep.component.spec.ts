import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDossierByDepComponent } from './list-dossier-by-dep.component';

describe('ListDossierByDepComponent', () => {
  let component: ListDossierByDepComponent;
  let fixture: ComponentFixture<ListDossierByDepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListDossierByDepComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListDossierByDepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
