import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../team';
import { TeamsService } from '../teams.service';

@Component({
  selector: 'app-createteam',
  templateUrl: './createteam.component.html',
  styleUrls: ['./createteam.component.css']
})
export class CreateteamComponent implements OnInit {
   team =new Team();
   msg='';
  constructor(private _service:TeamsService) { }

  ngOnInit(): void {
  }
   createTeam(){
     this._service.createTeamFromRemote(this.team).subscribe(
       (data)=>{
        this.msg="Successfully Created";
        alert("Successfully created team "+this.team.teamName)
         console.log("response received");
       },
       error=>{
         console.log("Exception occurs")
         this.msg="Team with this name is already exist";
       }
     );
   }
}
