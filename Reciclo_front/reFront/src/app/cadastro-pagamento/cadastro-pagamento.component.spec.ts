import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroPagamentoComponent } from './cadastro-pagamento.component';

describe('CadastroPagamentoComponent', () => {
  let component: CadastroPagamentoComponent;
  let fixture: ComponentFixture<CadastroPagamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroPagamentoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroPagamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
