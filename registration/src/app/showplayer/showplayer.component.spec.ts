import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowplayerComponent } from './showplayer.component';

describe('ShowplayerComponent', () => {
  let component: ShowplayerComponent;
  let fixture: ComponentFixture<ShowplayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowplayerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowplayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
