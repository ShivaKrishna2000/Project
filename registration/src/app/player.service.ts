import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Players } from './players';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  playerNames: string | undefined;
  teamName:string |undefined;
   playerId:number |undefined;
  constructor(private _http:HttpClient) { }

  public createPlayerFromRemote(player:Players):Observable<any>
  {
    return this._http.post("http://localhost:8083/createPlayer",player);
  }
  private baseURL="http://localhost:8083/getPlayer";
  
  getPlayerById(playerId:number):Observable<any>
  {
    return this._http.get("http://localhost:8083/getPlayer/"+playerId);
  }

  public getPlayerByTeamName(teamName?:string):Observable<any>
  {
    return this._http.get<any>("http://localhost:8083/getPlayers/"+teamName)
  }
}
