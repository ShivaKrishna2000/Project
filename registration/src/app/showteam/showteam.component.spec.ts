import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowteamComponent } from './showteam.component';

describe('ShowteamComponent', () => {
  let component: ShowteamComponent;
  let fixture: ComponentFixture<ShowteamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowteamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
