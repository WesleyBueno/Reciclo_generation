import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DecoracaoComponent } from './decoracao.component';

describe('DecoracaoComponent', () => {
  let component: DecoracaoComponent;
  let fixture: ComponentFixture<DecoracaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DecoracaoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DecoracaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
