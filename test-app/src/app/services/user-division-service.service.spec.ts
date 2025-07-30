import { TestBed } from '@angular/core/testing';

import { UserDivisionServiceService } from './user-division-service.service';

describe('UserDivisionServiceService', () => {
  let service: UserDivisionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserDivisionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
