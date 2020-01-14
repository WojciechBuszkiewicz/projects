import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotebooksWrapperComponent } from './notebooks-wrapper.component';

describe('NotebooksWrapperComponent', () => {
  let component: NotebooksWrapperComponent;
  let fixture: ComponentFixture<NotebooksWrapperComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotebooksWrapperComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotebooksWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
