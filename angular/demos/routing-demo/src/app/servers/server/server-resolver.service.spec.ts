import { TestBed } from '@angular/core/testing';

import { ServerResolverService } from './server-resolver.service';

describe('ServerResolverService', () => {
  let service: ServerResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServerResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
