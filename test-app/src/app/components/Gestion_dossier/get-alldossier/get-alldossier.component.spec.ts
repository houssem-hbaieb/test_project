import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAlldossierComponent } from './get-alldossier.component';

describe('GetAlldossierComponent', () => {
  let component: GetAlldossierComponent;
  let fixture: ComponentFixture<GetAlldossierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetAlldossierComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAlldossierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
