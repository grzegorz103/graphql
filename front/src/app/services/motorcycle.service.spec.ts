import { TestBed } from '@angular/core/testing';

import { MotorcycleService } from './motorcycle.service';

describe('MotorcycleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MotorcycleService = TestBed.get(MotorcycleService);
    expect(service).toBeTruthy();
  });
});
