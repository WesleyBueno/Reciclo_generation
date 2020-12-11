import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostCategoriaComponent } from './post-categoria.component';

describe('PostCategoriaComponent', () => {
  let component: PostCategoriaComponent;
  let fixture: ComponentFixture<PostCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostCategoriaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
