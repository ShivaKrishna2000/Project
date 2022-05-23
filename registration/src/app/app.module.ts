import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { MainHomeComponent } from './main-home/main-home.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CreateteamComponent } from './createteam/createteam.component';
import { CreateplayerComponent } from './createplayer/createplayer.component';
import { ShowplayerComponent } from './showplayer/showplayer.component';
import { ShowteamComponent } from './showteam/showteam.component';
import { PlayerService } from './player.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    MainHomeComponent,
    NavBarComponent,
    CreateteamComponent,
    CreateplayerComponent,
    ShowplayerComponent,
    ShowteamComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
