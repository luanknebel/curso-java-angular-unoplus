import { TestBed } from '@angular/core/testing';

import { TokenJwtService } from './token-jwt.service';

describe('TokenJwtService', () => {
  let service: TokenJwtService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenJwtService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
