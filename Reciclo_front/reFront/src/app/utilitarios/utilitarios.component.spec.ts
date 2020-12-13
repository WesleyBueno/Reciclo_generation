import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilitariosComponent } from './utilitarios.component';

describe('UtilitariosComponent', () => {
  let component: UtilitariosComponent;
  let fixture: ComponentFixture<UtilitariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilitariosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilitariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
