import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from './team';

@Injectable({
  providedIn: 'root'
})
export class TeamsService {

  constructor(private _http:HttpClient) { }

  public createTeamFromRemote(team:Team):Observable<any>{
    return this._http.post(" http://localhost:8082/createTeam ", team);
  }

  public getTeamNameFromRemote():Observable<any>{
   return this._http.get<any>("http://localhost:8082/getTeam ");
  }
}
