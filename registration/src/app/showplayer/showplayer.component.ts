import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from '../player.service';
import { Players } from '../players';

@Component({
  selector: 'app-showplayer',
  templateUrl: './showplayer.component.html',
  styleUrls: ['./showplayer.component.css']
})
export class ShowplayerComponent implements OnInit {
    player=new Players;
     playerId:number=2;
  constructor(private service:PlayerService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    
  }

  showPlayer()
  {
    
    // return this.service.getPlayerByName().subscribe(
     return this.service.getPlayerById( this.playerId).subscribe(data=>
      {
         
        this.player=data;
        console.log(this.player)
      });
  }
}
