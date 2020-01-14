import { NotebooksService } from './../services/notebooks.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notebooks-wrapper',
  templateUrl: './notebooks-wrapper.component.html',
  styleUrls: ['./notebooks-wrapper.component.css']
})
export class NotebooksWrapperComponent implements OnInit {
  private notebooks: any[] = [];
  private notes: any[] = [];
  currentNotebook: number;

  constructor(private notebooksService: NotebooksService) { }

  ngOnInit() {
    this.notebooksService.getNotebooks()
      .subscribe((response) => this.notebooks = response);
  }

  removeNotebook(event) {
    this.notebooksService.deleteNotebook(event)
      .subscribe(() => {
        let index = this.notebooks.findIndex(obj => obj.id === event)
        this.notebooks.splice(index, 1);
      });
  }

  addNotebook() {
    this.notebooksService.addNotebook()
      .subscribe((response) => {
        this.notebooks.push(response);
      })
  }
}
