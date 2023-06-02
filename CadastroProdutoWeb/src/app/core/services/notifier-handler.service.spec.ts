import { TestBed } from '@angular/core/testing';

import { NotifierHandlerService } from './notifier-handler.service';

describe('NotifierHandlerService', () => {
  let service: NotifierHandlerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotifierHandlerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
