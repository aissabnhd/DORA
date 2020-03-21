import { Component, OnInit } from '@angular/core';
import {Struct} from "../../interfaces/Struct";
import {StructService} from "../../services/Struct.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-gestion-aphp',
  templateUrl: './gestion-aphp.component.html',
  styleUrls: ['./gestion-aphp.component.css']
})
export class GestionAphpComponent implements OnInit {
  structs : Array<Struct> = [];
  constructor(private router : Router, private structService : StructService) { }

  ngOnInit() {
    this.structService.findAll().subscribe(
      data => this.structs = data
    )
  }

  update(id: number) {
    this.router.navigate(['/update_struct/' + id]);
  }
}
