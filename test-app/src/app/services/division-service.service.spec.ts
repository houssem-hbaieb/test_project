import { TestBed } from '@angular/core/testing';

import { DivisionServiceService } from './division-service.service';

describe('DivisionServiceService', () => {
  let service: DivisionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DivisionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
