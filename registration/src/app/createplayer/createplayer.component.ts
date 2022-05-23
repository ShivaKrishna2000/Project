import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { PlayerService } from '../player.service';
import { Players } from '../players';
import { Team } from '../team';
import { TeamsService } from '../teams.service';

@Component({
  selector: 'app-createplayer',
  templateUrl: './createplayer.component.html',
  styleUrls: ['./createplayer.component.css']
})
export class CreateplayerComponent implements OnInit {

  constructor(private teamService: TeamsService ,private playerService:PlayerService,private _router:Router ) { }
  teams=[];
   player=new Players();
   msg='';
  ngOnInit(): void {
    this.showAll();
  }

  createPlayer()
  {

    this.playerService.createPlayerFromRemote(this.player).subscribe(
      data =>{
        console.log(this.player);
        console.log("response received");
        this._router.navigate(['/main'])},
      error=> 
      {
        console.log("exception occured");
        this.msg="player can't be tagged to this team as it excceds team budgets ";
      }
    )

}
  showAll(){
    return this.teamService.getTeamNameFromRemote().subscribe(
      (data:any)=>{
        this.teams=data,
        console.log(this.teams)
      }
    )
  }
 
}
