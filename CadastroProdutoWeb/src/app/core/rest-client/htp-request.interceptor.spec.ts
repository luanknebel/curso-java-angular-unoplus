import { TestBed } from '@angular/core/testing';

import { HttpRequestInterceptor } from './htp-request.interceptor';

describe('HtpRequestInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HttpRequestInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: HttpRequestInterceptor = TestBed.inject(HttpRequestInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
