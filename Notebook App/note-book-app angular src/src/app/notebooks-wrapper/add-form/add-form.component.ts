import { NotebooksService } from './../../services/notebooks.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {
  @Output() addNotebook = new EventEmitter;

  constructor() { }



  ngOnInit() {
  }

  addNewNotebook() {
    this.addNotebook.emit();
  }

}
