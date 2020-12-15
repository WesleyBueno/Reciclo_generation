import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VestuarioComponent } from './vestuario.component';

describe('VestuarioComponent', () => {
  let component: VestuarioComponent;
  let fixture: ComponentFixture<VestuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VestuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VestuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
