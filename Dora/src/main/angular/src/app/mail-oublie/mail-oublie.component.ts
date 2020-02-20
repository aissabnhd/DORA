import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-mail-oublie',
  templateUrl: './mail-oublie.component.html',
  styleUrls: ['./mail-oublie.component.css']
})
export class MailOublieComponent implements OnInit {

  mailForm : FormGroup;

  constructor(private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.mailForm = this.formBuilder.group({
      mail: [null, Validators.required]
    });
  }

}
