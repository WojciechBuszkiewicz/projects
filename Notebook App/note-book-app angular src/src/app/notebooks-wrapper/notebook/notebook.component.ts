import { NotebooksService } from './../../services/notebooks.service';
import { Component, OnInit, Input, Output, EventEmitter, HostListener } from '@angular/core';

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
  styleUrls: ['./notebook.component.css']
})
export class NotebookComponent implements OnInit {
  @Input("title") title: string = "Default";
  @Input("id") id: number;
  @Output() deleteNotebook = new EventEmitter;


  constructor(private notebooksService: NotebooksService) { }

  ngOnInit() {
  }

  removeNotebook() {
    this.deleteNotebook.emit(this.id);
  }

  updateNotebook() {
    this.notebooksService.updateNotebook(this.id, this.title)
      .subscribe((resp) => {
        console.log(resp);
      })
  }



}
