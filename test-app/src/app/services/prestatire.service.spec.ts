import { TestBed } from '@angular/core/testing';

import { PrestatireService } from './prestatire.service';

describe('PrestatireService', () => {
  let service: PrestatireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrestatireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
