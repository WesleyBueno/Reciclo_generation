import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaUsuarioComponent } from './pagina-usuario.component';

describe('PaginaUsuarioComponent', () => {
  let component: PaginaUsuarioComponent;
  let fixture: ComponentFixture<PaginaUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaginaUsuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
